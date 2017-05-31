package com.calculator.upilemilanzi.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by upilemilanzi on 2017/05/25.
 */
public class CalculatorFunctionsTest {
    @Test
    public void divide() throws Exception {
        registerObserver();
        CalculatorFunctions.projectData.triggerDivide(6);
        CalculatorFunctions.projectData.triggerDivide(2);
        assertEquals("incorrect",3,CalculatorFunctions.projectData.DisplayData());
    }

    @Test
    public void multiply() throws Exception {
        registerObserver();
        CalculatorFunctions.projectData.triggerMultiply(2);
        CalculatorFunctions.projectData.triggerMultiply(3);
        assertEquals("incorrect",6,CalculatorFunctions.projectData.DisplayData());
    }

    @Test
    public void subtract() throws Exception {
        registerObserver();
        CalculatorFunctions.projectData.triggerSubtract(2);
        CalculatorFunctions.projectData.triggerSubtract(2);
        assertEquals("incorrect",0,CalculatorFunctions.projectData.DisplayData());
    }

    @Test
    public void addition() throws Exception {
        registerObserver();
        CalculatorFunctions.projectData.triggerAdd(2);
        CalculatorFunctions.projectData.triggerAdd(2);
        assertEquals("incorrect",4,CalculatorFunctions.projectData.DisplayData());
    }

    public void registerObserver(){
        new CalculatorFunctions();
    }

}