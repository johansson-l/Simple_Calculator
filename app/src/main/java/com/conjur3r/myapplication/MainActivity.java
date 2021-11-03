package com.conjur3r.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating variables for the number boxes
        final EditText firstNumber = findViewById(R.id.number1);
        final EditText secondNumber = findViewById(R.id.number2);

        // Variable declaration of various UI elements
        final RadioGroup operators = findViewById(R.id.operators);
        final RadioButton add = findViewById(R.id.add);
        final RadioButton subtract = findViewById(R.id.subtract);
        final Button equals = findViewById(R.id.equals);
        final TextView result = findViewById(R.id.result);

        // Setting up an event listener on the equals button
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Converting the boxes String values to Int
                final int firstNumberValue = Integer.parseInt(firstNumber.getText().toString());
                final int secondNumberValue = Integer.parseInt(secondNumber.getText().toString());

                //Function that stores which checkbox that's selected
                final int operatorButtonId = operators.getCheckedRadioButtonId();

                // Declaring Integer instead of Int just for being able to use toString() as the last call
                Integer answer;

                // Logic for what happens when the button is pressed
                if (operatorButtonId == add.getId()) {
                    //addition
                    answer = firstNumberValue + secondNumberValue;
                } else {
                    //subtraction
                    answer = firstNumberValue - secondNumberValue;
                }

                //Printing the answer to the textView box
                result.setText(answer.toString());
            }
        });

    }
}