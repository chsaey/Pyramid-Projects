package com.company;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;

import static com.company.Test.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Charset utf8 = StandardCharsets.UTF_8;

        //Creates a file if it does not exists -> overwrites the file by truncating and then writing
        Files.write(Paths.get("app.log"), Arrays.asList("1","2","3","4","5"),utf8);

        //Overloaded method. Tell it to create if it doesn't exists -> append instead of overriding
        Files.write(Paths.get("app.log"), Arrays.asList("6","7","8"),utf8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);

        Files.write(Paths.get("app.log"),"Hello World".getBytes());

        System.out.println(Files.readAllLines(Paths.get("app.log"),utf8));

    }



}


