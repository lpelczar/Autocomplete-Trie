package com.codecool.javatries;

import java.util.ArrayList;
import java.util.List;

public class AutoComplete {

    private TrieDataNode root;

    /**
     * Starts a new Trie with dummy root data "-"
     */
    public AutoComplete() {
        root = new TrieDataNode('-');
    }

    /**
     * Adds a word to the Trie
     * @param wordToAdd
     */
    public void addWord(String wordToAdd) {
        // TODO
    }

    /**
     * Returns the possible completions of baseChars String from the Trie
     * @param baseChars
     * @return possible completions
     */
    public List<String> autoComplete(String baseChars) {
        List<String> words = new ArrayList<>();
        // TODO
        return words;
    }

    /**
     * Removes a word from the Trie
     * @param wordToRemove
     * @return true if the removal was successful
     */
    public boolean removeWord(String wordToRemove) {
        // TODO -- Optional homework
        return false;
    }

}
