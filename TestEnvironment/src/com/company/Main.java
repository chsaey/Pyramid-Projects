package com.company;

//Files.readAllLines(Path.get(path));

import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Main {

    public static void main(String[] args) {

        String x = "12345";
        System.out.println(x.matches("[0-9]+"));
        StringBuilder sb = new StringBuilder("1");
        String t = "0".repeat(1);

        ArrayList<Integer> temp = new ArrayList<>();

        int [] res = temp.stream().mapToInt(Integer::intValue).toArray();


    }
}



