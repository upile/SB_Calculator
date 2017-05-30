package com.calculator.upilemilanzi.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private int[] numericButtons = {R.id.btnZero, R.id.btnOne, R.id.btnTwo, R.id.btnThree, R.id.btnFour, R.id.btnFive, R.id.btnSix, R.id.btnSeven, R.id.btnEight, R.id.btnNine};
    private int[] operatorButtons = {R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide, R.id.btnEqual, R.id.btnClear};

    int numberEntered = 0;
    TextView textToDisplay;
    TextView txtScreen;
    Activity activity;
    String currentOperator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;

        textToDisplay = (TextView) findViewById(R.id.txtDisplay);
        txtScreen = (TextView) findViewById(R.id.txtScreen);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        setNumericButtonClickListener();
        setOperatorOnClickListener();
    }

    public void setNumericButtonClickListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button) v;
                numberEntered = Integer.parseInt(button.getText().toString());
                DisplayText(Integer.toString(numberEntered));

                if(numberEntered != 0){
                    ChooseOperator(currentOperator);
                }
            }
        };
        // Assign the listener to all the numeric buttons
        for (int id : numericButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    private void setOperatorOnClickListener() {

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Button button = (Button)v;
                ChooseOperator(button.getText().toString());
                if(currentOperator != "C") {
                    DisplayText(button.getText().toString());
                }
            }
        };

        // Assign Listener to all  operator buttons
        for (int id : operatorButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    public void ChooseOperator(String operator){

        currentOperator = "";
        switch(operator){
            case "+":
                CalculatorFunctions.Addition(numberEntered);
                numberEntered = 0;
                break;

            case "-":
                CalculatorFunctions.Subtract(numberEntered);
                numberEntered = 0;
                break;

            case "/":
                CalculatorFunctions.Divide(numberEntered);
                numberEntered = 0;
                break;

            case "*":
                CalculatorFunctions.Multiply(numberEntered);
                numberEntered = 0;
                break;

            case "=":
                DisplayText(Integer.toString(CalculatorFunctions.Results()));
                break;

            case "C":
                CalculatorFunctions.currentTotal = 0;
                numberEntered = 0;
                DisplayText(Integer.toString(CalculatorFunctions.Results()));
                break;
        }
        currentOperator = operator;

    }

    public void DisplayText(String text){
        if(!text.equalsIgnoreCase("=") && !text.equalsIgnoreCase("C")) {
            txtScreen.setText(text);
            textToDisplay.append(text);
        }
        /*else {
            if(text.equalsIgnoreCase("=")) {
                textToDisplay.append(text);
                //textToDisplay.append(text);
            }
        }*/
    }
}
