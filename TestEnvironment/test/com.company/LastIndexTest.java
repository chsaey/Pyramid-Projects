package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LastIndexTest {
    @BeforeEach
    void setUp(){}

    @Test
    void testForLastIndex(){
        Practice practice = new Practice();

        ArrayList<Integer> list = new ArrayList<>(){{
            add(1);
            add(3);
            add(3);
            add(3);
            add(4);

        }};
        int result = practice.last(list,3);
        assertEquals(3,result);

    }

}
