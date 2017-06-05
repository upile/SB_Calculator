package com.upile.calculator.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.upile.calculator.R;
import com.upile.calculator.common.Constants;
import com.upile.calculator.operators.CalculatorOperators;

public class MainActivity extends AppCompatActivity {


    private int[] numericButtons = {R.id.btnZero, R.id.btnOne, R.id.btnTwo, R.id.btnThree, R.id.btnFour, R.id.btnFive, R.id.btnSix, R.id.btnSeven, R.id.btnEight, R.id.btnNine};
    private int[] operatorButtons = {R.id.btnAdd, R.id.btnSubtract, R.id.btnMultiply, R.id.btnDivide, R.id.btnEqual, R.id.btnClear};

    int numberEntered = 0;
    TextView textToDisplay;
    TextView txtScreen;
    Activity activity;
    String currentOperator = "";
    StringBuilder valueClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;

        //register observer
        new CalculatorOperators();
        valueClicked = new StringBuilder();

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
                String value = button.getText().toString();
                textToDisplay.append(value);
                valueClicked.append(value);
                numberEntered = Integer.parseInt(valueClicked.toString());
                displayText(Integer.toString(numberEntered));
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
                valueClicked = new StringBuilder();
                Button button = (Button)v;

                if(!currentOperator.equalsIgnoreCase(Constants.EQUAL_OPERATOR)){
                    chooseOperator(currentOperator);
                }

                chooseOperator(button.getText().toString());

                if(!currentOperator.equalsIgnoreCase(Constants.CANCEL_OPERATOR)) {
                    textToDisplay.append(button.getText().toString());
                    displayText(button.getText().toString());
                }
            }
        };

        // Assign Listener to all  operator buttons
        for (int id : operatorButtons) {
            findViewById(id).setOnClickListener(listener);
        }
    }

    public void chooseOperator(String operator){

        currentOperator = "";
        switch(operator){
            case Constants.ADD_OPERATOR:
                CalculatorOperators.projectData.triggerAdd(numberEntered);
                numberEntered = 0;
                break;

            case Constants.SUBTRACT_OPERATOR:
                CalculatorOperators.projectData.triggerSubtract(numberEntered);
                numberEntered = 0;
                break;

            case Constants.DIVIDE_OPERATOR:
                CalculatorOperators.projectData.triggerDivide(numberEntered);
                numberEntered = 0;
                break;

            case Constants.MULTIPLY_OPERATOR:
                CalculatorOperators.projectData.triggerMultiply(numberEntered);
                numberEntered = 0;
                break;

            case Constants.EQUAL_OPERATOR:
                displayText(Integer.toString(CalculatorOperators.projectData.displayData()));
                CalculatorOperators.currentTotal = 0;
                break;

            case Constants.CANCEL_OPERATOR:
                CalculatorOperators.currentTotal = 0;
                numberEntered = 0;
                displayText(Integer.toString(CalculatorOperators.projectData.displayData()));
                textToDisplay.append("");
                operator = "";
                break;
        }
        currentOperator = operator;

    }

    public void displayText(String text){
        if(!text.equalsIgnoreCase(Constants.EQUAL_OPERATOR) && !text.equalsIgnoreCase(Constants.CANCEL_OPERATOR)) {
            txtScreen.setText(text);
        }
        else{
            textToDisplay.setText("");
        }
    }
}
