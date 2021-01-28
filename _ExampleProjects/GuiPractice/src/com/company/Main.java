package com.company;

import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        createAFile();
    }

    public static void createAFile() {

        List<String> x = new ArrayList<>();
        try{
            //File file = new File("C:\\Users\\chsae\\Desktop\\pyramid-curriculum-2.0\\resources\\sample_data.txt");
            //file.createNewFile();

            Files.write(Paths.get("C:\\Users\\chsae\\desktop\\test.txt"),"heheheheheheh".getBytes());
        int[] x = {1,3};
            System.out.println(x.length);
        }
        catch(Exception e){}
    }
}
