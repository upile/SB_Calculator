package test;

import org.junit.Before;
import org.junit.Test;

import Calculator.CalculatorFunctions;

import static org.junit.Assert.*;

/**
 * Created by upilemilanzi on 2017/05/25.
 */
public class CalculatorFunctionsTest {
    @Test
    public void divide() throws Exception {
        CalculatorFunctions.projectData.TriggerDivide(6);
        CalculatorFunctions.projectData.TriggerDivide(2);
        assertEquals("Divide operator returns incorrect results",3,CalculatorFunctions.projectData.DisplayData());
    }

    @Test
    public void multiply() throws Exception {
        CalculatorFunctions.projectData.TriggerMultiply(2);
        CalculatorFunctions.projectData.TriggerMultiply(3);
        assertEquals("Multiply operator returns incorrect results",6,CalculatorFunctions.projectData.DisplayData());
    }

    @Test
    public void subtract() throws Exception {
        CalculatorFunctions.projectData.TriggerSubtract(2);
        CalculatorFunctions.projectData.TriggerSubtract(2);
        assertEquals("subtract operator returns incorrect results",0,CalculatorFunctions.projectData.DisplayData());
    }

    @Test
    public void addition() throws Exception {
        CalculatorFunctions.projectData.TriggerAdd(2);
        CalculatorFunctions.projectData.TriggerAdd(2);
        assertEquals("addition operator returns incorrect results",4,CalculatorFunctions.projectData.DisplayData());
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideByZeroException() {
        CalculatorFunctions.projectData.TriggerDivide(6);
        CalculatorFunctions.projectData.TriggerDivide(0);
    }

    @Before
    public void registerObserver(){
        new CalculatorFunctions();
    }

}