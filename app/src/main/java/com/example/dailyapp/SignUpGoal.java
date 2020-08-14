package com.example.dailyapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SignUpGoal extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up_goal);

        /*Listener button signUp*/
        Button buttonSubmit = (Button) findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUpGoalSubmit();
            }
        });
        /*Remove Error handling*/
        hideErrorHandling();

        /* Measurement used*/
        measurementUsed();
    }// OnCreate

    /*Sign up goal submit-------------------------*/
    public void signUpGoalSubmit() {

        //Open Database
        DBAdapter db = new DBAdapter(this);
        db.open();

        //Error
        ImageView imageViewError = (ImageView) findViewById(R.id.imageViewError);
        TextView textViewErrorMessage = (TextView) findViewById(R.id.textViewErrorMessage);
        String errorMessage = "";

        //Get target weight
        EditText editTextTargetWeight = (EditText) findViewById(R.id.editTextTargetWeight);
        String stringTargetWeight = editTextTargetWeight.getText().toString();
        double doubleTargetWeight = 0;
        try {
            doubleTargetWeight = Double.parseDouble(stringTargetWeight);
        } catch (NumberFormatException nfe) {
            errorMessage = " target weight has to be a number ";
        }

        /*spinner I want to*/
        Spinner spinnerIWantTo = (Spinner) findViewById(R.id.spinnerIWantTo);
        int intIWanTo = spinnerIWantTo.getSelectedItemPosition();
        // 0 -- Loose weight
        // 1 -- Gain weight

        /*spinner spinnerWeeklyGoal*/
        Spinner spinnerWeeklyGoal = (Spinner) findViewById(R.id.spinnerWeeklyGoal);
        String stringWeeklyGoal = spinnerWeeklyGoal.getSelectedItem().toString();

        if (errorMessage.isEmpty()) {
            // Update database

            long goalId = 1;

            double doubleTargetWeightSQL = db.quoteSmart(doubleTargetWeight);
            db.update("goal", "goal_id", goalId, "goal_target_weight", doubleTargetWeightSQL);

            int intIWanToSQL = db.quoteSmart(intIWanTo);
            db.update("goal", "goal_id", goalId, "goal_i_want_to", intIWanToSQL);

            String stringWeeklyGoalSQL = db.quoteSmart(stringWeeklyGoal);
            db.update("goal", "goal_id", goalId, "goal_weekly_goal", stringWeeklyGoalSQL);

        }
        /*Calculate energy*/
        if (errorMessage.isEmpty()) {
            /*get row number one from users*/
            long rowID = 1;
            String fields[] = new String[]{
                    "user_id",
                    "user_dob",
                    "user_gender",
                    "user_height",
                    "user_activity_level"
            };
            Cursor c = db.selectPrimary("users", "user_id", rowID, fields);

            String stringUserDob = c.getString(1);

            String stringUserGender = c.getString(2);

            String stringUserHeight = c.getString(3);

            String stringUserActivityLevel = c.getString(4);

            //Get age
            String[] items1 = stringUserDob.split("-");
            String stringYear = items1[0];
            String stringMonth = items1[1];
            String stringDay = items1[2];

            int intYear = 0;
            try {
                intYear = Integer.parseInt(stringYear);
            } catch (NumberFormatException nfe) {

            }

            int intMonth = 0;
            try {
                intMonth = Integer.parseInt(stringMonth);
            } catch (NumberFormatException nfe) {

            }

            int intDay = 0;
            try {
                intDay = Integer.parseInt(stringDay);
            } catch (NumberFormatException nfe) {
            }
            String stringUserAge = getAge(intYear, intMonth, intDay);
            int intUserAge = 0;
            try {
                intUserAge = Integer.parseInt(stringUserAge);
            } catch (NumberFormatException nfe) {
            }

            //height
            double doubleUserHeight = 0;
            try {
                doubleUserHeight = Double.parseDouble(stringUserHeight);
            } catch (NumberFormatException nfe) {
            }


            //Start calculation

            // 1: BMR
            double bmr = 0;
            if (stringUserGender.startsWith("m")) {
                //Male
                //BMR = 66.5 + (13.75 x kg body weight) + (5.003 x height in cm) - (6.755 x age)
                bmr = 66.5 + (13.75 * doubleTargetWeight) + (5.003 * doubleUserHeight) - (6.755 * intUserAge);
//                bmr=Math.round(bmr);

            } else {
                //Female
                //BMR = 55.1 + (9.563 x kg body weight) +(1.850 x height in cm) - (4.676 x age)
                bmr = 655 + (9.563 * doubleTargetWeight) + (1.850 * doubleUserHeight) - (4.676 * intUserAge);
//                bmr=Math.round(bmr);
            }
            bmr = Math.round(bmr);
            double energyBmrSQL = db.quoteSmart(bmr);
            long goalID = 1;
            db.update("goal", "goal_id", goalID, "goal_energy_bmr", energyBmrSQL);


            //protein carB fat BMR
            double proteinsBmr = Math.round(bmr * 25 / 100);
            double carbsBmr = Math.round(bmr * 50 / 100);
            double fatBmr = Math.round(bmr * 25 / 100);

            double proteinsBmrSQL = db.quoteSmart(proteinsBmr);
            double carbsBmrSQL = db.quoteSmart(carbsBmr);
            double fatBmrSQL = db.quoteSmart(fatBmr);
            db.update("goal", "goal_id", goalID, "goal_proteins_bmr", proteinsBmrSQL);
            db.update("goal", "goal_id", goalID, "goal_carbs_bmr", carbsBmrSQL);
            db.update("goal", "goal_id", goalID, "goal_fat_bmr", fatBmrSQL);

            /* 2 : Diet */
            //Lose or gain weight??
            double doubleWeeklyGoal = 0;

            try {
                doubleWeeklyGoal = Double.parseDouble(stringWeeklyGoal);
            } catch (NumberFormatException nfe) {

            }
            //1 kg fat = 7700 kcal
            double kCal = 0;
            double energyDiet = 0;
            kCal = 7700 * doubleWeeklyGoal;
            if (intIWanTo == 0) {
                //Loose weight
                energyDiet = Math.round(bmr - (kCal / 7));
            } else {
                energyDiet = Math.round(bmr + (kCal / 7));
            }

            //Update database
            double energyDietSQL = db.quoteSmart(energyDiet);
            db.update("goal", "goal_id", goalID, "goal_energy_diet", energyDietSQL);

            //protein carB fat Diet
            double proteinsDiet = Math.round(energyDiet * 25 / 100);
            double carbsDiet = Math.round(energyDiet * 50 / 100);
            double fatDiet = Math.round(energyDiet * 25 / 100);

            double  proteinsDietSQL = db.quoteSmart(proteinsDiet);
            double carbsDietSQL = db.quoteSmart(carbsDiet);
            double fatDietSQL = db.quoteSmart(fatDiet);
            db.update("goal", "goal_id", goalID, "goal_proteins_diet", proteinsDietSQL);
            db.update("goal", "goal_id", goalID, "goal_carbs_diet", carbsDietSQL);
            db.update("goal", "goal_id", goalID, "goal_fat_diet", fatDietSQL);

            /*---------With Activity level ------*/
            //Taking in to account activity
            double energyWithActivity = 0;
            if (stringUserActivityLevel.equals("0")) {
                energyWithActivity = bmr * 1.2;
            } else if (stringUserActivityLevel.equals("1")) {
                energyWithActivity = bmr * 1.375;  //slightly_active
            } else if (stringUserActivityLevel.equals("2")) {
                energyWithActivity = bmr * 1.55;  //moderately_active
            } else if (stringUserActivityLevel.equals("3")) {
                energyWithActivity = bmr * 1.725;  //active_lifestyle
            } else if (stringUserActivityLevel.equals("4")) {
                energyWithActivity = bmr * 1.9;  //very_active
            }
            energyWithActivity = Math.round(energyWithActivity);
            double energyWithActivitySQL = db.quoteSmart(energyWithActivity);
            db.update("goal", "goal_id", goalID, "goal_energy_with_activity", energyWithActivitySQL);

            double proteinsWithActivity = Math.round(energyWithActivity * 25 / 100);
            double carbsWithActivity = Math.round(energyWithActivity * 50 / 100);
            double fatWithActivity = Math.round(energyWithActivity * 25 / 100);

            double proteinsWithActivitySQL = db.quoteSmart(proteinsWithActivity);
            double carbsWithActivitySQL = db.quoteSmart(carbsWithActivity);
            double fatWithActivitySQL = db.quoteSmart(fatWithActivity);
            db.update("goal", "goal_id", goalID, "goal_proteins_with_activity", proteinsWithActivitySQL);
            db.update("goal", "goal_id", goalID, "goal_carbs_with_activity", carbsWithActivitySQL);
            db.update("goal", "goal_id", goalID, "goal_fat_with_activity", fatWithActivitySQL);


            /* 4 activity and diet */
            //1 kg fat = 7700 kcal
            kCal = 0;
            double energyWithActivityAndDiet = 0;
            kCal = 7700 * doubleWeeklyGoal;
            if (intIWanTo == 0) {
                //Loose weight
                energyWithActivityAndDiet = Math.round(bmr - (kCal / 7));
            } else {
                energyWithActivityAndDiet = Math.round(bmr + (kCal / 7));
            }

            //Update database
            double energyWithActivityAndDietSQL = db.quoteSmart(energyWithActivityAndDiet);
            db.update("goal", "goal_id", goalID, "goal_energy_with_activity_and_diet", energyWithActivityAndDietSQL);

            //Calculate protein

            double proteins = Math.round(energyWithActivityAndDiet * 25 / 100);
            double carbs = Math.round(energyWithActivityAndDiet * 50 / 100);
            double fat = Math.round(energyWithActivityAndDiet * 25 / 100);

            double proteinsSQL = db.quoteSmart(proteins);
            double carbsSQL = db.quoteSmart(carbs);
            double fatSQL = db.quoteSmart(fat);
            db.update("goal", "goal_id", goalID, "goal_proteins_with_activity_and_diet", proteinsSQL);
            db.update("goal", "goal_id", goalID, "goal_carbs_with_activity_and_diet", carbsSQL);
            db.update("goal", "goal_id", goalID, "goal_fat_with_activity_and_diet", fatSQL);

        }
        if (!(errorMessage.isEmpty())) {
            textViewErrorMessage.setText(errorMessage);
            imageViewError.setVisibility(View.VISIBLE);
            textViewErrorMessage.setVisibility(View.VISIBLE);
        }

        db.close();

        if (errorMessage.isEmpty()) {
            Intent i = new Intent(SignUpGoal.this, MainActivity.class);
            startActivity(i);
        }
    }

    /*Hide Error handling-------------------------*/
    public void hideErrorHandling() {

        /*Hide error icon and message*/
        ImageView imageViewError = (ImageView) findViewById(R.id.imageViewError);
        imageViewError.setVisibility(View.GONE);

        TextView textViewErrorMessage = (TextView) findViewById(R.id.textViewErrorMessage);
        textViewErrorMessage.setVisibility(View.GONE);
    }

    /* Measurement used----------------------*/
    public void measurementUsed() {
        /*Open database */
        DBAdapter db = new DBAdapter(this);
        db.open();

        /*get row number one from users*/
        long rowID = 1;
        String fields[] = new String[]{
                "user_id",
                "user_measurement"
        };
        Cursor c = db.selectPrimary("users", "user_id", rowID, fields);
        String measurement;
        measurement = c.getString(1);

        //Measurement or imperial?
        if (measurement.startsWith("m")) {

        } else {
            //Imperial
            //Kg to pound
            TextView textViewTargetMeasurementType = (TextView) findViewById(R.id.textViewTargetMeasurementType);
            textViewTargetMeasurementType.setText("pounds");

            //Kg each week
            TextView textViewKgEachWeek = (TextView) findViewById(R.id.textViewKgEachWeek);
            textViewKgEachWeek.setText("pounds each week");
        }
        /* Close database*/
        db.close();
    }

    /*get Age --------------------------------------*/
    private String getAge(int year, int month, int day) {
        Calendar dob = Calendar.getInstance();
        Calendar today = Calendar.getInstance();

        dob.set(year, month, day);

        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if (today.get(Calendar.DAY_OF_YEAR) < dob.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        Integer ageInt = new Integer(age);
        String ageS = ageInt.toString();

        return ageS;
    }
}
