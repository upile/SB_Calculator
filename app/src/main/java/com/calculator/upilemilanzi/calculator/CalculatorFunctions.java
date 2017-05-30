package com.calculator.upilemilanzi.calculator;

/**
 * Created by upilemilanzi on 2017/05/25.
 */

public class CalculatorFunctions {

    public static int currentTotal = 0;

    public static void Divide(int value){
        if(currentTotal != 0) {
            if(value != 0) {
                currentTotal = currentTotal / value;
            }
            else {
                throw new IllegalArgumentException("cannot divide by zero");
            }
        }
        else {
            currentTotal = value;
        }
    }

    public static void Multiply(int value){
        if(currentTotal != 0) {
            currentTotal = currentTotal * value;
        }
        else{
            currentTotal = value;
        }
    }

    public static void Subtract(int value){
        if(currentTotal != 0) {
            currentTotal = currentTotal - value;
        }
        else{
            currentTotal = value;
        }
    }

    public static void Addition(int value){
        currentTotal = currentTotal + value;
    }

    public static int Results(){
        return currentTotal;
    }

}
