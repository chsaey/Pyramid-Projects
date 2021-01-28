package test;


import main.Calculator;
import main.Greetings;

import org.junit.Test;
import org.junit.Assert;


public class GreetingsTest {
    @Test
    public void shouldReturnAnInstanceOfGreetings(){
       Greetings greetings = new Greetings();
       Assert.assertNotNull(greetings);
    }

    @Test
    public void shouldReturnHelloWorldWhenSayHelloIsCalled(){
        Greetings greetings = new Greetings();
        String result = greetings.sayHello();
        Assert.assertEquals("Hello World", result);
    }


}
