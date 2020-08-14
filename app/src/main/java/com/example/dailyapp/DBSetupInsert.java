package com.example.dailyapp;

import android.content.Context;

public class DBSetupInsert {

    //variable
    private final Context context;

    //public class -------------------------*/
    public DBSetupInsert(Context ctx) {
        this.context = ctx;
    }

    /* Setup in to food ---------------------*/
    //insert in to food table
    public void setupInsertFood(String values) {
        DBAdapter db = new DBAdapter(context);
        db.open();
        db.insert("food",
                "food_id,food_name,food_manufactor_name,food_serving_size,food_serving_measurement,food_serving_name_number,food_serving_name_word,food_energy,food_protein,food_carbohydrates,food_fat,food_energy_calculated,food_protein_calculated,food_carbohydrates_calculated,food_fat_calculated,food_user_id,food_barcode,food_category_id,food_thumb,food_image_a,food_image_b,food_image_c,food_notes",
                values);
        db.close();
    }

    //insert food into database---------------*/
    public void insertAllFood() {
        setupInsertFood("Null,'Egg, whole, cooked, hard-boiled', 'Prior', '13','gram','2','wtf','232','23','23','23','232','23','23','23','1','1','1','1','1','1','1','1'");
        setupInsertFood("Null,'Topping, dessert, brownie, chewy, baked, pieces', 'King', '1','gram','3','1 Serving','130','1','17','6','390','3','51','18','1','2','6','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, dessert, Reese’s no bake, dry svg', 'King', '1','gram','2','1 Serving','150','2','20','6','300','4','40','12','1','2','6','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, dessert, heath, nobake, dry svg', 'King', '1','gram','2','1 Serving','160','1','27','5','320','2','54','18','1','2','6','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, dessert, Almond Joy, no bake, dry svg', 'King', '1','gram','2','1 Serving','150','2','21','7','300','4','42','14','1','2','6','1','1','1','1','1'");
        setupInsertFood("Null,'Baking Chips, semi sweet chocolate, mini bits', 'Queen', '1','gram','2','1 Each','1759','15','224','89','3518','30','448','178','1','2','7','1','1','1','1','1'");
        setupInsertFood("Null,'Baking Chocolate, unswtnd, square', 'Queen', '1','gram','2','1 Each','145','4','9','15','290','8','18','30','1','2','7','1','1','1','1','1'");
        setupInsertFood("Null,'Baking Chocolate, unswtnd, grated', 'Queen', '1','gram','2','1 Each','165','4','10','17','330','8','20','34','1','2','7','1','1','1','1','1'");
        setupInsertFood("Null,'Baking Chips, chocolate, semi sweet', 'Queen', '1','gram','2',''1 Tablespoon','50','0','7','3','100','0','14','6','1','2','7','1','1','1','1','1'");
        setupInsertFood("Null,'Baking Chips, milk chocolate', 'Queen', '1','gram','2',''1 Tablespoon','56','1','6','3','112','2','12','6','1','2','7','1','1','1','1','1'");
        setupInsertFood("Null,'Baking Chips, butterscotch, confectioner’s coating candy', 'Queen', '1','gram','2','1 Tablespoon','57','0','7','3','114','0','14','6','1','2','7','1','1','1','1','1'");
        setupInsertFood("Null,'Biscuit, buttermilk, art flvr, refrig dough, pkg, Pillsbury', 'Queen', '1','gram','2','1 Serving','104','2','14','5','208','4','28','10','1','2','8','1','1','1','1','1'");
        setupInsertFood("Null,'Biscuit, Irg, McDonald’s ', 'Queen', '1','gram','2','1 Each','310','6','39','14','620','12','78','48','1','2','8','1','1','1','1','1'");
        setupInsertFood("Null,'Biscuit, buttermilk, purchased, dry mix ', 'Queen', '1','gram','4', '1/4 cup','128','2','19','5','514','8','76','18','1','2','8','1','1','1','1','1'");
        setupInsertFood("Null,'Biscuit, buttermilk, dry mix ', 'Queen', '1','gram','4',''1/4 cup','128','2','19','5','514','8','76','18','1','2','8','1','1','1','1','1'");
        setupInsertFood("Null,'Biscuit, buttermilk, higher fat, refrig dough ', 'Queen', '1','gram','2','1 each','138','3','19','6','276','6','38','12','1','2','8','1','1','1','1','1'");
        setupInsertFood("Null,'Drink, chocolate, dry mix ', 'Queen', '1','gram','2','2.5 Teaspoon','89','1','20','1','178','2','40','2','1','2','9','1','1','1','1','1'");
        setupInsertFood("Null,'Drink, strawberry, dry mix', 'Queen', '1','gram','2','2.5 Teaspoon','86','0','22','0','172','0','44','0','1','2','9','1','1','1','1','1'");
        setupInsertFood("Null,'Drink, carob, dry mix ', 'Queen', '1','gram','2','1 Teaspoon','45','0','11','0','90','0','22','0','1','2','9','1','1','1','1','1'");
        setupInsertFood("Null,'Drink, sports, lemonade, svg, Gatorade', 'Queen', '1','gram','2','8 Fluid ounce','63','0','16','0','126','0','32','0','1','2','9','1','1','1','1','1'");
        setupInsertFood("Null,'Drink, protein, Muscle Milk, powder, Cytosport', 'Queen', '1','gram','2','1 Tablespoon','45','5','2','2','90','10','4','4','1','2','9','1','1','1','1','1'");
        setupInsertFood("Null,'Soda, lemon lime, w/caff', 'Queen', '1','gram','2','8 Fluid ounce','101','0','26','0','202','0','52','0','1','2','10','1','1','1','1','1'");
        setupInsertFood("Null,'Soda, club', 'Queen', '1','gram','2','8 Fluid ounce','0','0','0','0','0','0','0','0','1','2','10','1','1','1','1','1'");
        setupInsertFood("Null,'Soda, ginner ale', 'Queen', '1','gram','2','1 Cup','83','0','21','0','166','0','42','0','1','2','10','1','1','1','1','1'");
        setupInsertFood("Null,'Soda, root beer', 'Queen', '1','gram','2','1 Cup','101','0','26','0','202','0','52','0','1','2','10','1','1','1','1','1'");
        setupInsertFood("Null,'Soda, grape', 'Queen', '1','gram','2','1 Cup','107','0','28','0','214','0','56','0','1','2','10','1','1','1','1','1'");
        setupInsertFood("Null,'Juice, fruit and vegetable juice twist, strawberry banana,Trader Joe’s ', 'Eucerin', '1','gram','2','8 Fluid ounce','120','1','28','0','240','2','56','0','1','2','11','1','1','1','1','1'");
        setupInsertFood("Null,'Meal, veggie omelette, w/fruit dish wheat toast and jelly ', 'Eucerin', '1','gram','2','1 Meal','272','22','43','2','544','44','86','4','1','2','11','1','1','1','1','1'");
        setupInsertFood("Null,'Meal, veggie burger w/fresh fruit, Mimi’s café ', 'Eucerin', '1','gram','2','1 Each','396','14','72','6','792','28','144','12’,'1','2','11','1','1','1','1','1'");
        setupInsertFood("Null,'Juice Drink, vegetable fruit, mixed, w/add nutrients ', 'Eucerin', '1','gram','2','8 Fluid ounce','72','0','18','0','144','0','36','0','1','2','11','1','1','1','1','1'");
        setupInsertFood("Null,'Juice Drink, vegetable and fruit, strawberry kiwi ', 'Eucerin', '1','gram','2','8 Fluid ounce','70','0','18','0','140','0','36','0','1','2','11','1','1','1','1','1'");
        setupInsertFood("Null,'Fruit Cocktail, canned, w/heavy syrup ', 'Eucerin', '1','gram','2','0.5 Cup','91','0','23','0','182','0','46','0','1','2','13','1','1','1','1','1'");
        setupInsertFood("Null,'Fruit Cocktail, canned, w/light syrup ', 'Eucerin', '1','gram','2','0.5 Cup','69','0','18','0','138','0','36','0','1','2','13','1','1','1','1','1'");
        setupInsertFood("Null,'Fruit Cocktail, canned, w/juice ', 'Eucerin', '1','gram','2','0.5 Cup','55','0','14','0','110','0','28','0','1','2','13','1','1','1','1','1'");
        setupInsertFood("Null,'Fruit Cocktail, canned, w/water ', 'Eucerin', '1','gram','2','0.5 Cup','38','0','10','0','76','0','20','0','1','2','13','1','1','1','1','1'");
        setupInsertFood("Null,'Vegetable, succotash, cooked/boiled f/frzn, drained ', 'Eucerin', '1','gram','2','0.5 Cup','79','4','17','1','158','8','34','2','1','2','14','1','1','1','1','1'");
        setupInsertFood("Null,'Vegetable, succotash, cooked/boiled, drained ', 'Eucerin', '1','gram','2','0.5 Cup','110','5','23','1','220','10','46','2','1','2','14','1','1','1','1','1'");
        setupInsertFood("Null,'Vegetable, peas and carrots, canned, w/liquid ', 'Eucerin', '1','gram','2','0.5 Cup','48','0','11','0','96','0','22','0','1','2','14','1','1','1','1','1'");
        setupInsertFood("Null,'Vegetable, succotash, fresh', 'Eucerin', '1','gram','2','4 Ounce-weight','112','2','22','1','224','4','44','2','1','2','14','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, Health Nut, Oroweat ', 'Eucerin', '1','gram','2','1 Slice','100','4','18','2','200','8','36','2','1','2','16','1','1','1','1','1'");
        setupInsertFood("Null,'Cereal, Healthy Fiber, multigrain flakes, Health Valley ', 'Eucerin', '1','gram','2','0.75 Cup','100','3','23','0','200','6','46','0','1','2','16','1','1','1','1','1'");
        setupInsertFood("Null,'Vegetable, healthy garden, frzn, C & W ', 'Eucerin', '1','gram','2','1 Cup','25','1','4','0','50','2','8','0','1','2','16','1','1','1','1','1'");
        setupInsertFood("Null,'Juice, Heart Healthy, pomegranate blend, Lakewood Juices ', 'Eucerin', '1','gram','2','8 Fluid ounce','125','2','31','0','250','4','62','0','1','2','16','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, soy, protein, Marshmallow Krunch, Revival Soy ', 'Eucerin', '1','gram','2','1 Each','220','17','30','3','440','34','60','6','1','2','18','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, soy, protein, Chocolate Temptation, Revival Soy ', 'Eucerin', '1','gram','2','1 Each','220','15','31','4','440','30','62','8','1','2','18','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, soy, protein, Peanut Butter Chocolate Pal, Revival Soy ', 'Eucerin', '1','gram','2','1 Each','240','16','30','6','480','32','60','12','1','2','18','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, energy, protein, banana chocolate, Nugo ', 'Eucerin', '1','gram','2','1 Each','190','17','25','3','380','34','50','6','1','2','18','1','1','1','1','1'");
        setupInsertFood("Null,'Protein, soy, powder, scoop, PR Nutrition ', 'Gold', '1','gram','2','2 Each','130','30','0','2','260','60','0','4','1','2','19','1','1','1','1','1'");
        setupInsertFood("Null,'Protein, soy, powder, Bob’s Red Mill ', 'Gold', '1','gram','2','1 Tablespoon','20','5','0','0','40','10','0','0','1','2','19','1','1','1','1','1'");
        setupInsertFood("Null,'Protein, hemp, powder, scoop, Manitoba Harvest ', 'Gold', '1','gram','2','2 Scoop','134','15','5','6','268','30','10','12','1','2','19','1','1','1','1','1'");
        setupInsertFood("Null,'Protein, soy, EAS, vanilla, powder', 'Gold', '1','gram','2','1 Scoop','170','20','19','2','340','40','38','4','1','2','19','1','1','1','1','1'");
        setupInsertFood("Null,'Meat Stick, summer sausage, pork & beef, w/cheddar cheese ', 'Sliver', '1','gram','2','1 Ounce-weight','121','6','1','11','242','12','2','22','1','2','21','1','1','1','1','1'");
        setupInsertFood("Null,'Meatloaf, meatless, w/gravy, slice, Gardenburger ', 'Sliver', '1','gram','2','1 Slice','130','12','12','4','260','24','24','8','1','2','21','1','1','1','1','1'");
        setupInsertFood("Null,'Meatloaf, w/gravy, frzn, Stouffer’s ', 'Sliver', '1','gram','2','1 Each','200','18','8','11','400','36','16','22','1','2','21','1','1','1','1','1'");
        setupInsertFood("Null,'Topping, dessert, brownie, chewy, baked, pieces', 'King', '1','gram','3','1 Serving','130','1','17','6','390','3','51','18','1','2','6','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, dessert, Reese’s no bake, dry svg', 'King', '1','gram','2','1 Serving','150','2','20','6','300','4','40','12','1','2','6','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, dessert, heath, nobake, dry svg', 'King', '1','gram','2','1 Serving','160','1','27','5','320','2','54','18','1','2','6','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, dessert, Almond Joy, no bake, dry svg', 'King', '1','gram','2','1 Serving','150','2','21','7','300','4','42','14','1','2','6','1','1','1','1','1'");
        setupInsertFood("Null,'Baking Chips, semi sweet chocolate, mini bits', 'Queen', '1','gram','2','1 Each','1759','15','224','89','3518','30','448','178','1','2','7','1','1','1','1','1'");
        setupInsertFood("Null,'Baking Chocolate, unswtnd, square', 'Queen', '1','gram','2','1 Each','145','4','9','15','290','8','18','30','1','2','7','1','1','1','1','1'");
        setupInsertFood("Null,'Baking Chocolate, unswtnd, grated', 'Queen', '1','gram','2','1 Each','165','4','10','17','330','8','20','34','1','2','7','1','1','1','1','1'");
        setupInsertFood("Null,'Baking Chips, chocolate, semi sweet', 'Queen', '1','gram','2',''1 Tablespoon','50','0','7','3','100','0','14','6','1','2','7','1','1','1','1','1'");
        setupInsertFood("Null,'Baking Chips, milk chocolate', 'Queen', '1','gram','2',''1 Tablespoon','56','1','6','3','112','2','12','6','1','2','7','1','1','1','1','1'");
        setupInsertFood("Null,'Baking Chips, butterscotch, confectioner’s coating candy', 'Queen', '1','gram','2','1 Tablespoon','57','0','7','3','114','0','14','6','1','2','7','1','1','1','1','1'");
        setupInsertFood("Null,'Biscuit, buttermilk, art flvr, refrig dough, pkg, Pillsbury', 'Queen', '1','gram','2','1 Serving','104','2','14','5','208','4','28','10','1','2','8','1','1','1','1','1'");
        setupInsertFood("Null,'Biscuit, Irg, McDonald’s ', 'Queen', '1','gram','2','1 Each','310','6','39','14','620','12','78','48','1','2','8','1','1','1','1','1'");
        setupInsertFood("Null,'Biscuit, buttermilk, purchased, dry mix ', 'Queen', '1','gram','4', '1/4 cup','128','2','19','5','514','8','76','18','1','2','8','1','1','1','1','1'");
        setupInsertFood("Null,'Biscuit, buttermilk, dry mix ', 'Queen', '1','gram','4',''1/4 cup','128','2','19','5','514','8','76','18','1','2','8','1','1','1','1','1'");
        setupInsertFood("Null,'Biscuit, buttermilk, higher fat, refrig dough ', 'Queen', '1','gram','2','1 each','138','3','19','6','276','6','38','12','1','2','8','1','1','1','1','1'");
        setupInsertFood("Null,'Drink, chocolate, dry mix ', 'Queen', '1','gram','2','2.5 Teaspoon','89','1','20','1','178','2','40','2','1','2','9','1','1','1','1','1'");
        setupInsertFood("Null,'Drink, strawberry, dry mix', 'Queen', '1','gram','2','2.5 Teaspoon','86','0','22','0','172','0','44','0','1','2','9','1','1','1','1','1'");
        setupInsertFood("Null,'Drink, carob, dry mix ', 'Queen', '1','gram','2','1 Teaspoon','45','0','11','0','90','0','22','0','1','2','9','1','1','1','1','1'");
        setupInsertFood("Null,'Drink, sports, lemonade, svg, Gatorade', 'Queen', '1','gram','2','8 Fluid ounce','63','0','16','0','126','0','32','0','1','2','9','1','1','1','1','1'");
        setupInsertFood("Null,'Drink, protein, Muscle Milk, powder, Cytosport', 'Queen', '1','gram','2','1 Tablespoon','45','5','2','2','90','10','4','4','1','2','9','1','1','1','1','1'");
        setupInsertFood("Null,'Soda, lemon lime, w/caff', 'Queen', '1','gram','2','8 Fluid ounce','101','0','26','0','202','0','52','0','1','2','10','1','1','1','1','1'");
        setupInsertFood("Null,'Soda, club', 'Queen', '1','gram','2','8 Fluid ounce','0','0','0','0','0','0','0','0','1','2','10','1','1','1','1','1'");
        setupInsertFood("Null,'Soda, ginner ale', 'Queen', '1','gram','2','1 Cup','83','0','21','0','166','0','42','0','1','2','10','1','1','1','1','1'");
        setupInsertFood("Null,'Soda, root beer', 'Queen', '1','gram','2','1 Cup','101','0','26','0','202','0','52','0','1','2','10','1','1','1','1','1'");
        setupInsertFood("Null,'Soda, grape', 'Queen', '1','gram','2','1 Cup','107','0','28','0','214','0','56','0','1','2','10','1','1','1','1','1'");
        setupInsertFood("Null,'Juice, fruit and vegetable juice twist, strawberry banana,Trader Joe’s ', 'Eucerin', '1','gram','2','8 Fluid ounce','120','1','28','0','240','2','56','0','1','2','11','1','1','1','1','1'");
        setupInsertFood("Null,'Meal, veggie omelette, w/fruit dish wheat toast and jelly ', 'Eucerin', '1','gram','2','1 Meal','272','22','43','2','544','44','86','4','1','2','11','1','1','1','1','1'");
        setupInsertFood("Null,'Meal, veggie burger w/fresh fruit, Mimi’s café ', 'Eucerin', '1','gram','2','1 Each','396','14','72','6','792','28','144','12’,'1','2','11','1','1','1','1','1'");
        setupInsertFood("Null,'Juice Drink, vegetable fruit, mixed, w/add nutrients ', 'Eucerin', '1','gram','2','8 Fluid ounce','72','0','18','0','144','0','36','0','1','2','11','1','1','1','1','1'");
        setupInsertFood("Null,'Juice Drink, vegetable and fruit, strawberry kiwi ', 'Eucerin', '1','gram','2','8 Fluid ounce','70','0','18','0','140','0','36','0','1','2','11','1','1','1','1','1'");
        setupInsertFood("Null,'Fruit Cocktail, canned, w/heavy syrup ', 'Eucerin', '1','gram','2','0.5 Cup','91','0','23','0','182','0','46','0','1','2','13','1','1','1','1','1'");
        setupInsertFood("Null,'Fruit Cocktail, canned, w/light syrup ', 'Eucerin', '1','gram','2','0.5 Cup','69','0','18','0','138','0','36','0','1','2','13','1','1','1','1','1'");
        setupInsertFood("Null,'Fruit Cocktail, canned, w/juice ', 'Eucerin', '1','gram','2','0.5 Cup','55','0','14','0','110','0','28','0','1','2','13','1','1','1','1','1'");
        setupInsertFood("Null,'Fruit Cocktail, canned, w/water ', 'Eucerin', '1','gram','2','0.5 Cup','38','0','10','0','76','0','20','0','1','2','13','1','1','1','1','1'");
        setupInsertFood("Null,'Vegetable, succotash, cooked/boiled f/frzn, drained ', 'Eucerin', '1','gram','2','0.5 Cup','79','4','17','1','158','8','34','2','1','2','14','1','1','1','1','1'");
        setupInsertFood("Null,'Vegetable, succotash, cooked/boiled, drained ', 'Eucerin', '1','gram','2','0.5 Cup','110','5','23','1','220','10','46','2','1','2','14','1','1','1','1','1'");
        setupInsertFood("Null,'Vegetable, peas and carrots, canned, w/liquid ', 'Eucerin', '1','gram','2','0.5 Cup','48','0','11','0','96','0','22','0','1','2','14','1','1','1','1','1'");
        setupInsertFood("Null,'Vegetable, succotash, fresh', 'Eucerin', '1','gram','2','4 Ounce-weight','112','2','22','1','224','4','44','2','1','2','14','1','1','1','1','1'");
        setupInsertFood("Null,'Bread, Health Nut, Oroweat ', 'Eucerin', '1','gram','2','1 Slice','100','4','18','2','200','8','36','2','1','2','16','1','1','1','1','1'");
        setupInsertFood("Null,'Cereal, Healthy Fiber, multigrain flakes, Health Valley ', 'Eucerin', '1','gram','2','0.75 Cup','100','3','23','0','200','6','46','0','1','2','16','1','1','1','1','1'");
        setupInsertFood("Null,'Vegetable, healthy garden, frzn, C & W ', 'Eucerin', '1','gram','2','1 Cup','25','1','4','0','50','2','8','0','1','2','16','1','1','1','1','1'");
        setupInsertFood("Null,'Juice, Heart Healthy, pomegranate blend, Lakewood Juices ', 'Eucerin', '1','gram','2','8 Fluid ounce','125','2','31','0','250','4','62','0','1','2','16','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, soy, protein, Marshmallow Krunch, Revival Soy ', 'Eucerin', '1','gram','2','1 Each','220','17','30','3','440','34','60','6','1','2','18','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, soy, protein, Chocolate Temptation, Revival Soy ', 'Eucerin', '1','gram','2','1 Each','220','15','31','4','440','30','62','8','1','2','18','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, soy, protein, Peanut Butter Chocolate Pal, Revival Soy ', 'Eucerin', '1','gram','2','1 Each','240','16','30','6','480','32','60','12','1','2','18','1','1','1','1','1'");
        setupInsertFood("Null,'Bar, energy, protein, banana chocolate, Nugo ', 'Eucerin', '1','gram','2','1 Each','190','17','25','3','380','34','50','6','1','2','18','1','1','1','1','1'");
        setupInsertFood("Null,'Protein, soy, powder, scoop, PR Nutrition ', 'Gold', '1','gram','2','2 Each','130','30','0','2','260','60','0','4','1','2','19','1','1','1','1','1'");

        setupInsertFood("Null,'Protein, soy, powder, Bob’s Red Mill ', 'Gold', '1','gram','2','1 Tablespoon','20','5','0','0','40','10','0','0','1','2','19','1','1','1','1','1'");

        setupInsertFood("Null,'Protein, hemp, powder, scoop, Manitoba Harvest ', 'Gold', '1','gram','2','2 Scoop','134','15','5','6','268','30','10','12','1','2','19','1','1','1','1','1'");

        setupInsertFood("Null,'Protein, soy, EAS, vanilla, powder', 'Gold', '1','gram','2','1 Scoop','170','20','19','2','340','40','38','4','1','2','19','1','1','1','1','1'");

        setupInsertFood("Null,'Meat Stick, summer sausage, pork & beef, w/cheddar cheese ', 'Sliver', '1','gram','2','1 Ounce-weight','121','6','1','11','242','12','2','22','1','2','21','1','1','1','1','1'");

        setupInsertFood("Null,'Meatloaf, meatless, w/gravy, slice, Gardenburger ', 'Sliver', '1','gram','2','1 Slice','130','12','12','4','260','24','24','8','1','2','21','1','1','1','1','1'");

        setupInsertFood("Null,'Meatloaf, w/gravy, frzn, Stouffer’s ', 'Sliver', '1','gram','2','1 Each','200','18','8','11','400','36','16','22','1','2','21','1','1','1','1','1'");

    }

    //insert in to category table
    public void setupInsertCategory(String values) {
        DBAdapter db = new DBAdapter((context));
        db.open();
        db.insert("category",
                "category_id,category_name,category_parent_id,category_icon,category_notes",
                values);
        db.close();
    }

    public void insertAllCategory() {
        setupInsertCategory("NULL,'Bread','0','','Null'");
        setupInsertCategory("NUll,'Bread','1','',NULl");
        setupInsertCategory("NUll,'Cereals','1','',NULl");
        setupInsertCategory("NUll,'Frozen bread and roll','1','',NULl");
        setupInsertCategory("NUll,'Crispbread','1','',NULl");

        setupInsertCategory("NUll,'Dessert and baking','0','',NULl");
        setupInsertCategory("NUll,'Baking','2','',NULl");
        setupInsertCategory("NULL,'Biscuit','2','',NULL");

        setupInsertCategory("NULL,'Drink','0','',NULL");
        setupInsertCategory("NULL,'Soda','3','',NULL");

        setupInsertCategory("NULL,'Fruit and vegetable','0','',NULL");
        setupInsertCategory("NULL,'Frozen fruit and vegetable','4','',NULL");
        setupInsertCategory("NULL,'fruit','4','',NULL");
        setupInsertCategory("NULL,'Vegetables','4','',NULL");
        setupInsertCategory("NULL,'Canned fruits and vegetables','2','',NULL");

        setupInsertCategory("NULL,'Health','0','',NULL");
        setupInsertCategory("NULL,'Meal substitutes','5','',NULL");
        setupInsertCategory("NULL,'Protein bars','5','',NULL");
        setupInsertCategory("NULL,'Protein powder','5','',NULL");

        setupInsertCategory("NULL,'Meet chicken and fish','0','',NULL");
        setupInsertCategory("NULL,'Meat','6','',NULL");
        setupInsertCategory("NULL,'Chicken','6','',NULL");
        setupInsertCategory("NULL,'Seafood','6','',NULL");

        setupInsertCategory("NULL,'Dairy and eggs','0','',NULL");
        setupInsertCategory("NULL,'Eggs','6','',NULL");
        setupInsertCategory("NULL,'Cream and sour cream','7','',NULL");
        setupInsertCategory("NULL,'Yogurt','7','',NULL");

        setupInsertCategory("NULL,'Dinner','0','',NULL");
        setupInsertCategory("NULL,'Ready dinner dishes','8','',NULL");
        setupInsertCategory("NULL,'Pizza','8','',NULL");
        setupInsertCategory("NULL,'Noodle','8','',NULL");
        setupInsertCategory("NULL,'pasta','8','',NULL");
        setupInsertCategory("NULL,'Rice','8','',NULL");
        setupInsertCategory("NULL,'Taco','8','',NULL");

        setupInsertCategory("NULL,'Cheese','0','',NULL");
        setupInsertCategory("NULL,'Cold meets','9','',NULL");

        setupInsertCategory("NULL,'On bread','0','',NULL");
        setupInsertCategory("NULL,'Cold meet','10','',NULL");
        setupInsertCategory("NULL,'Sweet spreads','10','',NULL");
        setupInsertCategory("NULL,'Jam','10','',NULL");

        setupInsertCategory("NULL,'Snack','0','',NULL");
        setupInsertCategory("NULL,'Nuts','11','',NULL");
        setupInsertCategory("NULL,'Potato chip','11','',NULL");

    }
}
