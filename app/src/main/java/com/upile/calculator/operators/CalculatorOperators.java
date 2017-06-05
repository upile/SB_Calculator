package com.upile.calculator.operators;

import com.upile.calculator.observable.OperatorObservers;
import com.upile.calculator.observable.OperatorTriggersEngine;

/**
 * Created by upilemilanzi on 2017/05/25.
 */

public class CalculatorOperators implements OperatorObservers {

    public static int currentTotal;
    public static OperatorTriggersEngine projectData;

    public CalculatorOperators(){

        //register the observer
        projectData = new OperatorTriggersEngine();
        projectData.registerObserver(this);
        currentTotal = 0;
    }

    @Override
    public void add(int value) {
        currentTotal = currentTotal + value;
    }

    @Override
    public void subtract(int value) {
        if(!isCurrentTotalZero(value)) {
            currentTotal = currentTotal - value;
        }
    }

    @Override
    public void divide(int value) {
        if(!isCurrentTotalZero(value)) {
            if(value != 0) {
                currentTotal = currentTotal / value;
            }
            else {
                throw new IllegalArgumentException("cannot divide by zero");
            }
        }
    }

    @Override
    public void multiply(int value) {
        if(!isCurrentTotalZero(value)) {
            currentTotal = currentTotal * value;
        }
    }

    /**
     * Checks if currentTotal is zero.
     * if currentTotal is zero, assigns the entered value to currentTotal
     * @return true if currentTotal is Zero, else false.
     */
    public boolean isCurrentTotalZero(int value){
        if(currentTotal == 0) {
            currentTotal = value;
            return true;
        }
        return false;
    }

    @Override
    public int displayData() {
        return currentTotal;
    }
}
