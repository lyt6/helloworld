package com.helloworld.demo.leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache extends LinkedHashMap<Integer,Integer>{

    private int capacity;
    public LRUCache(int initialCapacity) {
        super(initialCapacity, 0.75f,true);
        this.capacity = initialCapacity;
    }

    @Override
    public Integer get(Object key) {
        return super.getOrDefault(key,-1);
    }

    @Override
    public Integer put(Integer key, Integer value) {
        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size()>capacity;
    }

}
