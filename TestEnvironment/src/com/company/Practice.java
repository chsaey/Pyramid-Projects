package com.company;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Practice {

    public int last(ArrayList<Integer> x, int target) {
        for (int i = x.size() - 1; i >= 0; i--) {
            if (x.get(i) == target) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Integer> pascal(int n) {
        ArrayList<Integer> previous = new ArrayList<>() {{
            add(1);
        }};

        if (n == 1) {
            return previous;
        }

        for (int i = 1; i < n; i++) {
            ArrayList<Integer> current = new ArrayList<>();
            current.add(1);
            for (int t = 1; t < i; t++) {
                current.add(previous.get(t) + previous.get(t - 1));
            }
            current.add(1);
            previous = current;
        }
        return previous;
    }

    public ArrayList<Integer> sort(ArrayList<Integer> data) {
        Collections.sort(data);
        return data;
    }

    public int[] sortArr(int[] data) {
        Arrays.sort(data);
        List<Integer> wrap = IntStream.of(data).boxed().collect(Collectors.toList());
        Collections.reverse(wrap);
        int[] result = wrap.stream().mapToInt(i -> i).toArray();

        return result;
    }

    public ArrayList<Integer> addOne(ArrayList<Integer> data) {
        ArrayList<Integer> x = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int n : data) {
            sb.append(n);
        }
        int num = Integer.parseInt(sb.toString()) + 1;
        while (num > 0) {
            x.add(num % 10);
            num /= 10;
        }
        Collections.reverse(x);

        return x;

    }

    public ArrayList<Integer> revSort(ArrayList<Integer> data) {
        Collections.sort(data);
        Collections.reverse(data);
        return data;
    }


    public ArrayList<Integer> incData(ArrayList<Integer> data) {

        return data.stream().map(e -> e + 1).collect(Collectors.toCollection(ArrayList<Integer>::new));
    }

    public Integer reduce(ArrayList<Integer> data) {
        return data.stream().reduce(0, (sub, ele) -> sub * ele);
    }

    public ArrayList<Integer> filter(ArrayList<Integer> data) {
        return data.stream().filter(e -> e % 2 == 0).collect(Collectors.toCollection(ArrayList<Integer>::new));
    }

    public void createAFile() {
        try {
            Files.write(Paths.get("C:\\Users\\chsae\\Desktop\\sample_data.txt"), "yoffffff".getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            Files.createFile(Paths.get("C:\\Users\\chsae\\Desktop\\tt.txt"));
        } catch (Exception e) {
        }
    }
}

