package com.example.dailyapp;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RecipeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RecipeFragment extends Fragment {
    /*- 01 Class Variables -------------------------------------------------------------- */
    private View mainView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView _recyclerView;
    private RecyclerView.Adapter _mAdapter;
    private RecyclerView.LayoutManager _layoutManager;
    private ScrollView _mainScrollView;

    private String currentMealNumber;
    private Cursor listCursor;
    private Cursor listCursorFood;

    private String currentFoodId;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RecipeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RecipeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RecipeFragment newInstance(String param1, String param2) {
        RecipeFragment fragment = new RecipeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private GoalFragment.OnFragmentInteractionListener mListener;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        /* Set title */
        ((FragmentActivity) getActivity()).getSupportActionBar().setTitle("Recipe   ");

        setHasOptionsMenu(true);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            currentMealNumber = bundle.getString("mealNumber");
            currentFoodId = bundle.getString("currentFoodId");
        }
        populateRecipe();


        // Create menu

    } //

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.activity_osean_profile, container, false);

        return mainView;
    }

    /*- 07 set main view ----------------------------------------------------------------- */
    // Changing view method in fragmetn
    private void setMainView(int id) {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mainView = inflater.inflate(id, null);
        ViewGroup rootView = (ViewGroup) getView();
        rootView.removeAllViews();
        rootView.addView(mainView);
    }

    /*- 08 on Create Options Menu -------------------------------------------------------- */
    // Creating action icon on toolbar
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        // Inflate menu


        inflater.inflate(R.menu.menu_recipe, menu);

        // Assign menu items to variables

        //menuItemDelete = menu.findItem(R.id.menu_action_food_delete);

        // Hide as default
        // menuItemEdit.setVisible(false);
        //menuItemDelete.setVisible(false);
    }

    public void populateRecipe() {
        /* Database */
        DBAdapter db = new DBAdapter(getActivity());
        db.open();

        // Get categories
        String fields[] = new String[]{
                "_id",
                "food_name",
                "food_image_a"
        };
        String currentFoodIdSQL = db.quoteSmart(currentMealNumber);
        Toast.makeText(getActivity(), currentFoodIdSQL, Toast.LENGTH_LONG).show();
//
        listCursorFood = db.select("food", fields, "_id", currentFoodIdSQL);

        String fields1[] = new String[]{
                "_id",
                "food_id",
                "mesurement",
                "ingredient1",
                "ingredient2",
                "ingredient3",
                "ingredient4",
                "step11",
                "step12",
                "step21"
        };
        listCursor = db.select("recipe", fields1, "food_id", currentFoodIdSQL);

        String stringId = listCursor.getString(0);
        String stringName = listCursorFood.getString(1);
        String stringImage = listCursorFood.getString(2);
        String stringMesurement = listCursor.getString(2);
        String stringIngredient1 = listCursor.getString(3);
        String stringIngredient2 = listCursor.getString(4);
        String stringIngredient3 = listCursor.getString(5);
        String stringIngredient4 = listCursor.getString(6);
        String stringStep11 = listCursor.getString(7);
        String stringStep12 = listCursor.getString(8);
        String stringStep13 = listCursor.getString(9);

        HashMap<String, Integer> images = new HashMap<String, Integer>();
        images.put("aulie_speltlomper_med_havre_a", Integer.valueOf(R.drawable.aulie_speltlomper_med_havre_a));
        images.put("aulie_speltlomper_med_havre_b", Integer.valueOf(R.drawable.aulie_speltlomper_med_havre_b));


        ImageView imageView1 = (ImageView) getView().findViewById(R.id.id_profile_image);
        imageView1.setImageResource(images.get(stringImage).intValue());

        TextView textViewTitle= (TextView) getView().findViewById(R.id.id_fullName_TextView);
        textViewTitle.setText(stringName);

        TextView textViewMesurment = (TextView) getView().findViewById(R.id.id_description_TextView);
        textViewMesurment.setText(stringMesurement);

        TextView textViewIngredient1 = (TextView) getView().findViewById(R.id.id_body_TextView);
        textViewIngredient1.setText(stringIngredient1);

        TextView textViewIngredient2 = (TextView) getView().findViewById(R.id.id_body_TextView2);
        textViewIngredient2.setText(stringIngredient2);

        TextView textViewIngredient3 = (TextView) getView().findViewById(R.id.id_body_TextView3);
        textViewIngredient3.setText(stringIngredient3);

        TextView textViewIngredient4 = (TextView) getView().findViewById(R.id.id_body_TextView4);
        textViewIngredient4.setText(stringIngredient4);

        TextView textViewStep11 = (TextView) getView().findViewById(R.id.id_body_TextViewStep1Content1);
        textViewStep11.setText("        "+stringStep11);

        TextView textViewStep12 = (TextView) getView().findViewById(R.id.id_body_TextViewStep1Content2);
        textViewStep12.setText("        "+stringStep12);

        TextView textViewStep21 = (TextView) getView().findViewById(R.id.id_body_TextViewStep2Content1);
        textViewStep21.setText("        "+stringStep13);


        db.close();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof GoalFragment.OnFragmentInteractionListener) {
            mListener = (GoalFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

}