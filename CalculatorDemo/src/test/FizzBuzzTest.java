package test;

import main.FizzBuzz;
import org.junit.Assert;
import org.junit.Test;

public class FizzBuzzTest {
    @Test
    public void shouldReturnAFizzBuzzClassWhenCalled(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        Assert.assertNotNull(fizzBuzz);
    }

    @Test
    public void shouldReturnBuzz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.test(5);
        Assert.assertEquals("Buzz",result);

    }
    @Test
    public void shouldReturnFizz3(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.test(3);
        Assert.assertEquals("Fizz", result);
    }

    @Test
    public void shouldReturnFizz2(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.test(6);
        Assert.assertEquals("Fizz", result);
    }

    @Test
    public void shouldReturnNum(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.test(1);
        Assert.assertEquals("1", result);
    }

    @Test
    public void shouldReturnFizzBuzz(){
        FizzBuzz fizzBuzz = new FizzBuzz();
        String result = fizzBuzz.test(15);
        Assert.assertEquals("FizzBuzz",result);

    }}
