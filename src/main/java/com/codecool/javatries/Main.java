package com.codecool.javatries;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Path worldListPath = new File("assets/wordList.txt").toPath();
        List wordList = Files.readAllLines(worldListPath);

        AutoComplete ac = new AutoComplete(wordList);

        // sample stuff here
        ac.autoComplete("a", 5);

        System.out.println("done");
    }
}