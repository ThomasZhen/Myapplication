package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class MainActivity5 extends AppCompatActivity {

    Button buttonM;
    Button buttonC;
    Button buttonR;
    Button buttonW;
    Button buttonS;

    int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);



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
        value = sharedPreferences.getInt("values", 0);

    }

    public void updateView(){

        String textEnergy = "Summary: The total energy consumed today is ";
        if(value <= 1500){
            textEnergy += "NORMAL, ";
        } else if (value > 1500 && value <= 2000) {
            textEnergy += "A BIT HIGH, ";
        } else if (value > 2000) {
            textEnergy += "VERY HIGH, ";
        }

        textEnergy += "you have eaten quite a variety of foods, and they should have given you enough nutrients.";
        ((TextView) findViewById(R.id.textView18)).setText(textEnergy);

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