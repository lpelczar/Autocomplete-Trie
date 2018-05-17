package com.codecool.javatries;

import java.util.*;
import java.util.Map.Entry;

public class AutoComplete {

    private TrieDataNode root;

    public AutoComplete() {
        root = new TrieDataNode('-');
    }

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

    public List<String> autoComplete(String baseChars) {

        StringBuilder stringBuilder = new StringBuilder();
        TrieDataNode current = root;
        for (char letter : baseChars.toCharArray()) {
            if (!current.getChildren().containsKey(Character.toUpperCase(letter)) &&
                !current.getChildren().containsKey(Character.toLowerCase(letter))) {
                return Collections.emptyList();
            }
            if (current.getChildren().get(Character.toUpperCase(letter)) != null) {
                current = current.getChildren().get(Character.toUpperCase(letter));
                stringBuilder.append(Character.toUpperCase(letter));
            } else {
                current = current.getChildren().get(Character.toLowerCase(letter));
                stringBuilder.append(Character.toLowerCase(letter));
            }
        }
        if (current.getChildren().entrySet().isEmpty()) {
            return Collections.singletonList(baseChars);
        }
        return getAllWords(current, stringBuilder.toString());
    }

    private List<String> getAllWords(TrieDataNode current, String baseChars) {
        List<String> results = new ArrayList<>();
        for (Entry<Character, TrieDataNode> map : current.getChildren().entrySet()) {
            if (map.getValue().isEndOfWord()) {
                results.add(baseChars + map.getValue().getLetter());
            }
            results.addAll(getAllWords(map.getValue(), baseChars + map.getValue().getLetter()));
        }
        Collections.sort(results);
        return results;
    }

    public boolean removeWord(String wordToRemove) {
        return remove(root, wordToRemove, 0);
    }

    private boolean remove(TrieDataNode current, String word, int index) {

        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieDataNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }

        boolean deleteCurrentNode = remove(node, word, index + 1);

        if (deleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

}
