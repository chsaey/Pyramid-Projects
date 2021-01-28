package test;

import main.Calculator;
import main.Validation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    private Calculator calculator;
    private Validation validation;

    @Before
    public void setUp(){
        validation = new Validation();
        calculator = new Calculator(validation);

    }

    @Test
    public void calcNullTest() {

        Assert.assertNotNull(calculator);
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldThroughAnExceptionWhenThreeDecimalPlaceValuePassed(){

        calculator.add("1.111", "1.111");
    }

    @Test
    public void shouldAddNumbersWhenCalled() {

        String result = calculator.add("1.11", "1.11");

        Assert.assertEquals("2.22", result);
    }

    @Test
    public void shouldAddNumbersWhenCalled2() {

        String result = calculator.add("-1.11", "-1.11");
        Assert.assertEquals("-2.22", result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenSubtracting(){

        String result = calculator.subtract("1.111","1.111");
    }

    @Test
    public void shouldSubtractNumbersWhenCalled() {

        String result = calculator.subtract("1.11", "1.11");
        Assert.assertEquals("0.00",result);
    }

    @Test
    public void multiply(){
        String result = calculator.multiply("1.1","1.1");
        Assert.assertEquals("1.21",result);
    }

    @Test
    public void divide(){
        String result = calculator.divide("1.1","1.1");
        Assert.assertEquals("1",result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void multiplyThrowException(){
        String result = calculator.multiply("1.111","1.111");
    }

    @Test(expected = IllegalArgumentException.class)
    public void divideThrowException(){
        String result = calculator.multiply("1.111","1.111");
    }
}