package com.codecool.javatries;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        Path worldListPath = new File("assets/wordlist.txt").toPath();
        List<String> wordList = Files.readAllLines(worldListPath);

        AutoComplete ac = new AutoComplete();
        for (String word : wordList) {
            ac.addWord(word);
        }

        System.out.println(ac.autoComplete("spectro"));
        System.out.println("done");
    }
}