package com.codecool.javatries;

import java.util.*;
import java.util.Map.Entry;

public class AutoComplete {

    private TrieDataNode root;

    /**
     * Starts a new Trie with dummy root data "-"
     */
    public AutoComplete() {
        root = new TrieDataNode('-');
    }

    /**
     * Adds a word to the Trie.
     */
    public void addWord(String wordToAdd) {
        TrieDataNode currentNode = root;
        for (char letter : wordToAdd.toCharArray()) {
            if (currentNode.getChildren().containsKey(letter)) {
                currentNode = currentNode.getChildren().get(letter);
            } else {
                TrieDataNode node = new TrieDataNode(letter);
                currentNode.getChildren().put(letter, node);
                currentNode = node;
            }
        }
        currentNode.setEndOfWord(true);
    }

    /**
     * Returns the possible completions of baseChars String from the Trie.
     * @param baseChars The String to autocomplete.
     * @return possible completions. An empty list if there are none.
     */
    public List<String> autoComplete(String baseChars) {

        TrieDataNode current = root;
        for (char letter : baseChars.toCharArray()) {
            if (!current.getChildren().containsKey(letter)) {
                return Collections.emptyList();
            }
            current = current.getChildren().get(letter);
        }
        return getAllWords(current, baseChars);
    }

    private List<String> getAllWords(TrieDataNode current, String baseChars) {
        List<String> results = new ArrayList<>();
        for (Entry<Character, TrieDataNode> map : current.getChildren().entrySet()) {
            if (map.getValue().isEndOfWord()) {
                results.add(baseChars + map.getValue().getLetter());
            }
            results.addAll(getAllWords(map.getValue(), baseChars + map.getValue().getLetter()));
        }
        return results;
    }

    /**
     * Removes a word from the Trie
     * @return true if the removal was successful
     */
    public boolean removeWord(String wordToRemove) {
        // TODO -- Optional homework
        return false;
    }

}
