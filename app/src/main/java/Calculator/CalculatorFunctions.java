package calculator;

import observable.ObjectObserver;
import observable.ProjectData;

/**
 * Created by upilemilanzi on 2017/05/25.
 */

public class CalculatorFunctions implements ObjectObserver {

    public static int currentTotal = 0;
    public static ProjectData projectData;

    public CalculatorFunctions(){

        //register the observer
        projectData = new ProjectData();
        projectData.RegisterObserver(this);
    }

    @Override
    public void Add(int value) {
        currentTotal = currentTotal + value;
    }

    @Override
    public void Subtract(int value) {
        if(!IsCurrentTotalZero(value)) {
            currentTotal = currentTotal - value;
        }
    }

    @Override
    public void Divide(int value) {
        if(!IsCurrentTotalZero(value)) {
            if(value != 0) {
                currentTotal = currentTotal / value;
            }
            else {
                throw new IllegalArgumentException("cannot divide by zero");
            }
        }
    }

    @Override
    public void Multiply(int value) {
        if(!IsCurrentTotalZero(value)) {
            currentTotal = currentTotal * value;
        }
    }

    /**
     * Checks if currentTotal is zero.
     * if currentTotal is zero, assigns the enterd
     * @return A String data type.
     */
    public boolean IsCurrentTotalZero(int value){
        if(currentTotal == 0) {
            currentTotal = value;
            return true;
        }
        return false;
    }

    @Override
    public int DisplayData() {
        return currentTotal;
    }
}
