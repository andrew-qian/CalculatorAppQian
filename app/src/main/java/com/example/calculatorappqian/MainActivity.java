package com.example.calculatorappqian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    double oldVal = 0;
    double evenOlderVal = 0;


    boolean lastPressPlus = false;
    boolean lastPressMinus = false;
    boolean lastPressDivide = false;
    boolean lastPressMultiply = false;
    boolean lastPressExponent = false;

    @Override
    public void onClick (View v){ //Cite: (remove need for multiple onCLickListener methods) https://androidacademic.blogspot.com/2016/12/multiple-buttons-onclicklistener-android.html
        TextView outputBox = findViewById(R.id.outputBox);
        TextView beforeBox = findViewById(R.id.beforeBox);
        int id = v.getId();
        if (id == R.id.buttonOne){
            if (oldVal >= 0){oldVal = (oldVal * 10) + 1;} else{oldVal = (oldVal * 10) - 1;}
        }
        else if(id == R.id.buttonTwo) {
            if (oldVal >= 0){oldVal = (oldVal * 10) + 2;} else{oldVal = (oldVal * 10) - 2;}
        }
        else if(id == R.id.buttonThree) {
            if (oldVal >= 0){oldVal = (oldVal * 10) + 3;} else{oldVal = (oldVal * 10) - 3;}
        }
        else if(id == R.id.buttonFour) {
            if (oldVal >= 0){oldVal = (oldVal * 10) + 4;} else{oldVal = (oldVal * 10) - 4;}
        }
        else if(id == R.id.buttonFive) {
            if (oldVal >= 0){oldVal = (oldVal * 10) + 5;} else{oldVal = (oldVal * 10) - 5;}
        }
        else if(id == R.id.buttonSix) {
            if (oldVal >= 0){oldVal = (oldVal * 10) + 6;} else{oldVal = (oldVal * 10) - 6;}
        }
        else if(id == R.id.buttonSeven) {
            if (oldVal >= 0){oldVal = (oldVal * 10) + 7;} else{oldVal = (oldVal * 10) - 7;}
        }
        else if(id == R.id.buttonEight) {
            if (oldVal >= 0){oldVal = (oldVal * 10) + 8;} else{oldVal = (oldVal * 10) - 8;}
        }
        else if(id == R.id.buttonNine) {
            if (oldVal >= 0){oldVal = (oldVal * 10) + 9;} else{oldVal = (oldVal * 10) - 9;}
        }
        else if(id == R.id.buttonZero) {
            oldVal = (oldVal * 10);
        }
        else if(id == R.id.buttonPlusMinus) {
            oldVal = -oldVal;
        }
        else if(id == R.id.buttonAC) {
            oldVal = 0;
            evenOlderVal = 0;
            lastPressPlus = false;
            lastPressMinus = false;
            lastPressDivide = false;
            lastPressMultiply = false;
            lastPressExponent = false;
        }
        else if(id == R.id.buttonPlus) {
            evenOlderVal = oldVal;
            oldVal = 0;
            lastPressPlus = true;
            lastPressMinus = false;
            lastPressDivide = false;
            lastPressMultiply = false;
            lastPressExponent = false;

        }
        else if(id == R.id.buttonMinus) {
            evenOlderVal = oldVal;
            oldVal = 0;
            lastPressPlus = false;
            lastPressMinus = true;
            lastPressDivide = false;
            lastPressMultiply = false;
            lastPressExponent = false;

        }
        else if(id == R.id.buttonDivide) {
            evenOlderVal = oldVal;
            oldVal = 0;
            lastPressPlus = false;
            lastPressMinus = false;
            lastPressDivide = true;
            lastPressMultiply = false;
            lastPressExponent = false;


        }
        else if(id == R.id.buttonMultiply) {
            evenOlderVal = oldVal;
            oldVal = 0;
            lastPressPlus = false;
            lastPressMinus = false;
            lastPressDivide = false;
            lastPressMultiply = true;
            lastPressExponent = false;

        }
        else if(id == R.id.buttonExponent) {
            evenOlderVal = oldVal;
            oldVal = 0;
            lastPressPlus = false;
            lastPressMinus = false;
            lastPressDivide = false;
            lastPressMultiply = false;
            lastPressExponent = true;

        }
        else if(id == R.id.buttonEquals){
            if (lastPressPlus){
                oldVal = evenOlderVal + oldVal;
            }
            else if (lastPressMinus){
                oldVal = evenOlderVal - oldVal;
            }
            else if(lastPressMultiply){
                oldVal = evenOlderVal * oldVal;
            }
            else if(lastPressDivide){
                oldVal = evenOlderVal/oldVal;
            }
            else if(lastPressExponent){
                oldVal = Math.pow(evenOlderVal, oldVal);
            }
            else{

            }

        }
        if (oldVal % 1 == 0 && oldVal < Integer.MAX_VALUE){ //pretty print for if ending in .0 and scientific notation when number gets big
            outputBox.setText("" + (int) oldVal);
        }
        else{
            outputBox.setText("" + oldVal);
        }

        if (evenOlderVal % 1 == 0 && evenOlderVal < Integer.MAX_VALUE){ //pretty print for if ending in .0 and scientific notation when number gets big
            beforeBox.setText("" + (int) evenOlderVal);
        }
        else{
            beforeBox.setText("" + evenOlderVal);
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button one = findViewById(R.id.buttonOne); //Cite: (remove need for multiple onCLickListener methods) https://androidacademic.blogspot.com/2016/12/multiple-buttons-onclicklistener-android.html
        one.setOnClickListener(this);
        Button two = findViewById(R.id.buttonTwo);
        two.setOnClickListener(this);
        Button three = findViewById(R.id.buttonThree);
        three.setOnClickListener(this);
        Button four = findViewById(R.id.buttonFour);
        four.setOnClickListener(this);
        Button five = findViewById(R.id.buttonFive);
        five.setOnClickListener(this);
        Button six = findViewById(R.id.buttonSix);
        six.setOnClickListener(this);
        Button seven = findViewById(R.id.buttonSeven);
        seven.setOnClickListener(this);
        Button eight = findViewById(R.id.buttonEight);
        eight.setOnClickListener(this);
        Button nine = findViewById(R.id.buttonNine);
        nine.setOnClickListener(this);
        Button zero = findViewById(R.id.buttonZero);
        zero.setOnClickListener(this);
        Button plusMinus = findViewById(R.id.buttonPlusMinus);
        plusMinus.setOnClickListener(this);
        Button AC = findViewById(R.id.buttonAC);
        AC.setOnClickListener(this);
        Button plus = findViewById(R.id.buttonPlus);
        plus.setOnClickListener(this);
        Button minus = findViewById(R.id.buttonMinus);
        minus.setOnClickListener(this);
        Button multiply = findViewById(R.id.buttonMultiply);
        multiply.setOnClickListener(this);
        Button divide = findViewById(R.id.buttonDivide);
        divide.setOnClickListener(this);
        Button exponent = findViewById(R.id.buttonExponent);
        exponent.setOnClickListener(this);
        Button equals = findViewById(R.id.buttonEquals);
        equals.setOnClickListener(this);
    }


}