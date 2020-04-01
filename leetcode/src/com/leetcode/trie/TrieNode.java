package com.leetcode.trie;

import java.util.HashMap;
import java.util.Map;

class TrieNode {
    public char c;
    public HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    public boolean isEndWord = false;

    TrieNode(char c) {
        this.c = c;
    }

    public TrieNode() {

    }

    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append(c + (isEndWord ? "." : ""));
        b.append("\n");
        for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
            b.append(entry.getValue().toString());
        }
        b.append("\n");
        return b.toString();

    }

}