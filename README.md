# Autocomplete app

Console app using trie data structure that make autocomplete suggestions from given word list.

## Description

Tries (sometimes called prefix trees) is a variant of the tree where a single character is stored at each node.

Each path down the tree represents a word. At the bottom of the tree null nodes (indicated by * in the image) denote the end of a word. The actual implementation of these nodes is usually a special type of node, for example TerminatingNode which inherits from TrieNode.

![c1](http://i68.tinypic.com/9a1ikw.png)

Your task is to implement the following:

- Add code that implements such Trie data structure 
- Implement a function called addWord(String wordToAdd) that allows you to add words to your Trie.
- Load and add all the words from the wordList.txt thats in the repo.
- Implement a function wit the signature autoComplete(String wordBase). maxResults denotes how many results to return. If there are too many return the first ones in alphabetical order. For example if the input is "spectrog" it should return "spectrogram, spectrograph, spectrographic, spectrographically". Optional: Limit the number of results returned to 10.
- (optional) Implement a function called boolean removeWord(String wordToRemove): This function removes the given word from your Trie. It should return true if the removal was successful, false if the word was not in the trie.

## More info

Project made for [Codecool](https://codecool.com/) programming course.

