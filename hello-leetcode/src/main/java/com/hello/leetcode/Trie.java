package com.hello.leetcode;

/**
 * Trie本身就是root
 * 字典树
 */
public class Trie {

    private Trie[] children;
    private boolean isEnd;

    public Trie(){
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word){
        Trie temp = this;
        // for is terminal
        for (char c : word.toCharArray()) {
            if(this.children[c - 'a'] == null){
                temp.children[c - 'a'] = new Trie();
            }
            // drill down
            temp = temp.children[c - 'a'];
        }
        temp.isEnd = true;
    }
    public boolean search(String word){
        return false;
    }
    public boolean startsWith(String prefix) {
        return false;
    }

    public Trie prefixSearch(String word){
        Trie temp = this;
        for (char c : word.toCharArray()) {
            if(this.children[c - 'a'] == null){
                return null;
            }
            temp = temp.children[c - 'a'];
        }
        return temp;
    }

}
