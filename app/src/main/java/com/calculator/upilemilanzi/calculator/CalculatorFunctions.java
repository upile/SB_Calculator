package com.calculator.upilemilanzi.calculator;

import Observable.ObjectObserver;
import Observable.ProjectData;

/**
 * Created by upilemilanzi on 2017/05/25.
 */

public class CalculatorFunctions implements ObjectObserver {

    public static int currentTotal = 0;
    static ProjectData projectData;

    public CalculatorFunctions(){

        //register the observer
        projectData = new ProjectData();
        projectData.registerObserver(this);
    }

    @Override
    public void Add(int value) {
        currentTotal = currentTotal + value;
    }

    @Override
    public void Subtract(int value) {
        if(currentTotal != 0) {
            currentTotal = currentTotal - value;
        }
        else{
            currentTotal = value;
        }
    }

    @Override
    public void Divide(int value) {
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

    @Override
    public void Multiply(int value) {
        if(currentTotal != 0) {
            currentTotal = currentTotal * value;
        }
        else{
            currentTotal = value;
        }
    }

    @Override
    public int DisplayData() {
        return currentTotal;
    }
}
