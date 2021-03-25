package com.helloworld.demo.leetcode.tree;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    LinkedHashMap<Integer, Integer> linkedHashMap = null;

    public LRUCache(int capacity) {
        linkedHashMap = new LinkedHashMap(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                if (linkedHashMap.size() > capacity) {
                    return true;
                } else {
                    return false;
                }
            }
        };
    }

    public int get(int key) {
        Integer value = this.linkedHashMap.get(key);
        return value == null ? -1 : value;
    }

    public void put(int key, int value) {
        this.linkedHashMap.put(key, value);
    }

    public static void main(String[] args) {

    }
}