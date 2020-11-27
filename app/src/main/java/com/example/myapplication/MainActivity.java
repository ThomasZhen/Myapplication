package com.example.myapplication;

import  androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.Drawable;
import android.content.SharedPreferences;
import android.content.Context;
import java.util.ArrayList;
import com.google.gson.Gson;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Array;
import java.util.List;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    String foodName;
    String quantity;

    int value = 0;
    private String currCalories = "";

    EditText foodNameInput;
    EditText quantityInput;

    Button submitButton;
    Button buttonReset;
    Button buttonM;
    Button buttonC;
    Button buttonR;
    Button buttonW;
    Button buttonS;
    ArrayList<String> names;
    ArrayList<String> numbers;
    ArrayList<Integer> energy;

    // --------- Tesing variables -----------
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TEXT = "text";
    public static final String SWITCH1 = "switch1";
    // --------- Testing variables ----------


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        energy = new ArrayList<Integer>();

        loadData();
        updateView();


        if(names == null){
            showToast("names is exactly " + names);
            names = new ArrayList<String>();
        }
        if(numbers == null){
            showToast("numberss is exactly " + numbers);
            numbers = new ArrayList<String>();
        }

        // The two input textView
        foodNameInput = (EditText) findViewById(R.id.foodNameInput);
        quantityInput = (EditText) findViewById(R.id.quantityInput);


        // ------------ The Submit button -------------
        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
                drawable.getPaint().setColor(Color.parseColor("blue"));


                foodName = foodNameInput.getText().toString();
                quantity = quantityInput.getText().toString();

                value += 200;
                currCalories = value + "";
                String textCalories = currCalories + "/2000";
                ((TextView) findViewById(R.id.mark)).setText(textCalories);


                TextView tv = (TextView) findViewById(R.id.mark);


                if (value > 1500 && value <= 2000) {
                    tv.setBackgroundResource(R.drawable.yellow_circle);
                }


                if (value > 2000) {
                    tv.setBackgroundResource(R.drawable.red_circle);
                }


                names.add(foodName);

                numbers.add(quantity);

                energy.add(value);

            }
        }); // ------------ End of setOnClickListener method for submit button ---------------



        buttonReset = (Button) findViewById(R.id.reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetData();
            }
        });



        buttonM = (Button) findViewById(R.id.buttonM);
        buttonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();

                openActivity1();
            }
        });


        buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                saveData();

                openActivity2();
            }
        });


        buttonR = (Button) findViewById(R.id.buttonR);
        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                saveData();

                openActivity3();
            }
        });


        buttonW = (Button) findViewById(R.id.buttonW);
        buttonW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                saveData();

                openActivity4();
            }
        });


        buttonS = (Button) findViewById(R.id.buttonS);
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                saveData();

                openActivity5();
            }
        });

    } // ------ end of onCreate Method ------------


    public void saveData(){
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("calories", currCalories);
        editor.putInt("values", value);

        Gson gson = new Gson();
        String json1 = gson.toJson(names);

        editor.putString("Names", json1);

        String json2 = gson.toJson(numbers);

        editor.putString("Numbers", json2);

        editor.apply();
    }


    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
        currCalories = sharedPreferences.getString("calories", "");
        value = sharedPreferences.getInt("values", 0);

        Gson gson = new Gson();

        String json1 = sharedPreferences.getString("Names", "json1 default value");
        String json2 = sharedPreferences.getString("Numbers", "json2 default value");

        Type type1 = new TypeToken<ArrayList<String>>() {}.getType();
        Type type2 = new TypeToken<ArrayList<String>>() {}.getType();

        if(json1 == null){
            Log.d("mainActivity", "json1 is " + json1);
        } else if(!json1.equals("json1 default value")) {
            names = gson.fromJson(json1, type1);
        }

        if(json2 == null) {
            Log.d("mainActivity", "json2 is " + json2);
        } else if(!json2.equals("json2 default value")) {
            numbers = gson.fromJson(json2, type2);
        }


    }


    public void updateView(){
        String tempText = currCalories + "/2000";
        ((TextView) findViewById(R.id.mark)).setText(tempText);

        TextView tvs = (TextView) findViewById(R.id.mark);


        if (value > 1500 && value <= 2000) {
            tvs.setBackgroundResource(R.drawable.yellow_circle);
        }


        if (value > 2000) {
            tvs.setBackgroundResource(R.drawable.red_circle);
        }
    }


    protected void resetData() {
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        // ------- testing code --------
        editor.remove("Names");
        editor.remove("Numbers");
        editor.remove("calories");
        editor.remove("values");
        // -------- testing code --------

//        editor.clear(); // working
        editor.apply(); // commit changes

        currCalories = "";
        value = 0;
        names = null;
        numbers = null;

        TextView tvs = (TextView) findViewById(R.id.mark);

        String tempText = "/2000";
        ((TextView) findViewById(R.id.mark)).setText(tempText);

        tvs.setBackgroundResource(R.drawable.circle);
    }

//    @Override
//    protected void onStop() {
//        super.onStop();  // Always call the superclass method first
//        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
//        editor.clear();
//        editor.apply(); // commit changes
//    }



    private void showToast(String text){
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
    }


    private void openActivity1() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    private void openActivity2() {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }


    private void openActivity3() {
        Intent intent = new Intent(this, MainActivity3.class);
        startActivity(intent);
    }


    private void openActivity4() {
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }


    private void openActivity5() {
        Intent intent = new Intent(this, MainActivity5.class);
        if(energy.size() > 0){
            intent.putExtra("energy", energy.get(0));
        }
        startActivity(intent);
    }
}