package com.example.myapplication;

import  androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.util.Log;
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

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity2 extends AppCompatActivity {


    Button buttonM;
    Button buttonC;
    Button buttonR;
    Button buttonW;
    Button buttonS;

    ArrayList<String> names;
    ArrayList<String> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        buttonM = (Button) findViewById(R.id.buttonM);
        buttonM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();
            }
        });

        buttonC = (Button) findViewById(R.id.buttonC);
        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });

        buttonR = (Button) findViewById(R.id.buttonR);
        buttonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity3();
            }
        });

        buttonW = (Button) findViewById(R.id.buttonW);
        buttonW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity4();
            }
        });

        buttonS = (Button) findViewById(R.id.buttonS);
        buttonS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });

        loadData();
        updateView();

    }



    public void loadData(){
        SharedPreferences sharedPreferences = getSharedPreferences("myKey", MODE_PRIVATE);

        Gson gson = new Gson();

        String json1 = sharedPreferences.getString("Names", "json1 default value");
        String json2 = sharedPreferences.getString("Numbers", "json2 default value");

        if(json1 != null && json2 != null) {
            Type type1 = new TypeToken<ArrayList<String>>() {
            }.getType();
            Type type2 = new TypeToken<ArrayList<String>>() {
            }.getType();

            if (!json1.equals("json1 default value")) {
                names = gson.fromJson(json1, type1);
            }

            if (!json2.equals("json2 default value")) {
                numbers = gson.fromJson(json2, type2);
//            Log.d("testing2", "numbers.size() is " + numbers.size());
            }

        }

    }



    public void updateView(){

        if(names != null) {

            if (names.size() < 1) {
                String foodName1 = "Textview";
                String number1 = "Textview";
                TextView food1 = findViewById(R.id.food1);
                TextView quantity1 = findViewById(R.id.quantity1);
                food1.setText(foodName1);
                quantity1.setText(number1);

                String foodName2 = "Textview";
                String number2 = "Textview";
                TextView food2 = findViewById(R.id.food2);
                TextView quantity2 = findViewById(R.id.quantity2);
                food2.setText(foodName2);
                quantity2.setText(number2);

                String foodName3 = "Textview";
                String number3 = "Textview";
                TextView food3 = findViewById(R.id.food3);
                TextView quantity3 = findViewById(R.id.quantity3);
                food3.setText(foodName3);
                quantity3.setText(number3);

                String foodName4 = "Textview";
                String number4 = "Textview";
                TextView food4 = findViewById(R.id.food4);
                TextView quantity4 = findViewById(R.id.quantity4);
                food4.setText(foodName4);
                quantity4.setText(number4);

                String foodName5 = "Textview";
                String number5 = "Textview";
                TextView food5 = findViewById(R.id.food5);
                TextView quantity5 = findViewById(R.id.quantity5);
                food5.setText(foodName5);
                quantity5.setText(number5);
            }

            if (names.size() >= 1) {
                String foodName1;
                String number1;
                if (names.size() == 1 || names.size() <= 5) {
                    foodName1 = names.get(0);
                    number1 = numbers.get(0);
                } else {
                    foodName1 = names.get(names.size() - 5);
                    number1 = numbers.get(numbers.size() - 5);
                }
                TextView food1 = findViewById(R.id.food1);
                TextView quantity1 = findViewById(R.id.quantity1);

                food1.setText(foodName1);
                quantity1.setText(number1);
            }

            if (names.size() >= 2) {
                String foodName2;
                String number2;
                if (names.size() == 2 || names.size() <= 5) {
                    foodName2 = names.get(1);
                    number2 = numbers.get(1);
                } else {
                    foodName2 = names.get(names.size() - 4);
                    number2 = numbers.get(numbers.size() - 4);
                }
                TextView food2 = findViewById(R.id.food2);
                TextView quantity2 = findViewById(R.id.quantity2);

                food2.setText(foodName2);
                quantity2.setText(number2);
            }

            if (names.size() >= 3) {
                String foodName3;
                String number3;

                if (names.size() == 3 || names.size() <= 5) {
                    foodName3 = names.get(2);
                    number3 = numbers.get(2);
                } else {
                    foodName3 = names.get(names.size() - 3);
                    number3 = numbers.get(numbers.size() - 3);
                }
                TextView food3 = findViewById(R.id.food3);
                TextView quantity3 = findViewById(R.id.quantity3);

                food3.setText(foodName3);
                quantity3.setText(number3);
            }

            if (names.size() >= 4) {
                String foodName4;
                String number4;

                if (names.size() == 4 || names.size() <= 5) {
                    foodName4 = names.get(3);
                    number4 = numbers.get(3);
                } else {
                    foodName4 = names.get(names.size() - 2);
                    number4 = numbers.get(numbers.size() - 2);
                }

                TextView food4 = findViewById(R.id.food4);
                TextView quantity4 = findViewById(R.id.quantity4);

                food4.setText(foodName4);
                quantity4.setText(number4);
            }

            if (names.size() >= 5) {
                String foodName5;
                String number5;

                if (names.size() == 5) {
                    foodName5 = names.get(4);
                    number5 = numbers.get(4);
                } else {
                    foodName5 = names.get(names.size() - 1);
                    number5 = numbers.get(numbers.size() - 1);
                }

                TextView food5 = findViewById(R.id.food5);
                TextView quantity5 = findViewById(R.id.quantity5);

                food5.setText(foodName5);
                quantity5.setText(number5);
            }
        }
    }


    private void showToast(String text){
        Toast.makeText(MainActivity2.this, text, Toast.LENGTH_SHORT).show();
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
        startActivity(intent);
    }

}