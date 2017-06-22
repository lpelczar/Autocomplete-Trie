package com.codecool.javatries;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AutoCompleteTest {

    @Test
    void autoComplete() throws IOException {
        Path worldListPath = new File("assets/wordlist.txt").toPath();
        List<String> wordList = Files.readAllLines(worldListPath);
        AutoComplete ac = new AutoComplete();
        for (String str : wordList) {
            ac.addWord(str);
        }
        List<String> results = ac.autoComplete("spectro");
        List<String> expected = Arrays.asList(new String[]{"spectrogram", "spectrograph", "spectrographic", "spectrographically",
                "spectrometric", "spectrophotometer", "spectroscope", "spectroscopic", "spectroscopy"});
        assertIterableEquals(expected, results);
    }

}