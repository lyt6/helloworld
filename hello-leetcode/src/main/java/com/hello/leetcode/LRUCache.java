package com.hello.leetcode;

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
        return linkedHashMap.get(key) == null ? -1 : linkedHashMap.get(key);
    }

    public void put(int key, int value) {
        linkedHashMap.put(key, value);
    }

}