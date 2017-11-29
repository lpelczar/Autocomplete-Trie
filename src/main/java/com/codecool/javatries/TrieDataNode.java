package com.codecool.javatries;

public class TrieDataNode {

    private char data;
    // TODO add further members as needed

    /**
     * Initializes a TrieDataNode with its data
     * @param data The data in this node
     */
    public TrieDataNode(char data) {
        this.data = data;
    }

    public char getData() {
        return data;
    }

    @Override
    public String toString() {
        return Character.toString(data);
    }

}
