package com.calculator.upilemilanzi.calculator;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by upilemilanzi on 2017/05/25.
 */
public class CalculatorFunctionsTest {
    @Test
    public void divide() throws Exception {
        CalculatorFunctions.Divide(6);
        CalculatorFunctions.Divide(2);
        assertEquals("incorrect",3,CalculatorFunctions.Results());
    }

    @Test
    public void multiply() throws Exception {
        CalculatorFunctions.Multiply(2);
        CalculatorFunctions.Multiply(3);
        assertEquals("incorrect",6,CalculatorFunctions.Results());
    }

    @Test
    public void subtract() throws Exception {
        CalculatorFunctions.Subtract(2);
        CalculatorFunctions.Subtract(2);
        assertEquals("incorrect",0,CalculatorFunctions.Results());
    }

    @Test
    public void addition() throws Exception {
        CalculatorFunctions.Addition(2);
        CalculatorFunctions.Addition(2);
        assertEquals("incorrect",4,CalculatorFunctions.Results());
    }

}