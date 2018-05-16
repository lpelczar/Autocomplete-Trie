package com.codecool.javatries;

import java.util.HashMap;
import java.util.Map;

public class TrieDataNode {

    private char letter;
    private Map<Character, TrieDataNode> children;
    private boolean isEndOfWord;

    /**
     * Initializes a TrieDataNode with its letter
     * @param letter The letter in this node
     */
    public TrieDataNode(char letter) {
        this.letter = letter;
        this.children = new HashMap<>();
    }

    public char getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return Character.toString(letter);
    }

    public Map<Character, TrieDataNode> getChildren() {
        return children;
    }

    public void setChildren(Map<Character, TrieDataNode> children) {
        this.children = children;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}
