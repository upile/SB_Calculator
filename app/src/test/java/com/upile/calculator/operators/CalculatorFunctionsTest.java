package com.upile.calculator.operators;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by upilemilanzi on 2017/05/25.
 */
public class CalculatorFunctionsTest {
    @Test
    public void divide() throws Exception {
        CalculatorOperators.projectData.triggerDivide(6);
        CalculatorOperators.projectData.triggerDivide(2);
        assertEquals("divide operator returns incorrect results",3, CalculatorOperators.projectData.displayData());
    }

    @Test
    public void multiply() throws Exception {
        CalculatorOperators.projectData.triggerMultiply(2);
        CalculatorOperators.projectData.triggerMultiply(3);
        assertEquals("multiply operator returns incorrect results",6, CalculatorOperators.projectData.displayData());
    }

    @Test
    public void subtract() throws Exception {
        CalculatorOperators.projectData.triggerSubtract(2);
        CalculatorOperators.projectData.triggerSubtract(2);
        assertEquals("subtract operator returns incorrect results",0, CalculatorOperators.projectData.displayData());
    }

    @Test
    public void addition() throws Exception {
        CalculatorOperators.projectData.triggerAdd(2);
        CalculatorOperators.projectData.triggerAdd(2);
        assertEquals("addition operator returns incorrect results",4, CalculatorOperators.projectData.displayData());
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideByZeroException() {
        CalculatorOperators.projectData.triggerDivide(6);
        CalculatorOperators.projectData.triggerDivide(0);
    }

    @Before
    public void registerObserver(){
        new CalculatorOperators();
    }

}