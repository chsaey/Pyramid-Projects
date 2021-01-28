package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class SortTest {

    @BeforeEach
    void setup(){

    }

    @Test
    void testSort(){
        Practice practice = new Practice();
        ArrayList<Integer> base = new ArrayList<>(){{
            add(1);
            add(7);
            add(64);
            add(50);
            add(3);

        }};

        ArrayList<Integer> expected = new ArrayList<>(){{
            add(1);
            add(3);
            add(7);
            add(50);
            add(64);
        }};

        ArrayList<Integer> result = practice.sort(base);

        assertEquals(result,expected);







    }
}
