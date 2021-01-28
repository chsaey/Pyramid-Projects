package com.company;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PascalTest {

    @Test
    void testPascal(){
        Practice practice = new Practice();
        ArrayList<Integer> expected = new ArrayList<>(){{
            add(1);
            add(4);
            add(6);
            add(4);
            add(1);

        }};
        assertEquals(expected,practice.pascal(5));

    }

}
