package com.helloworld.demo.javase;

import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.*;

public class partitionList {

    public static void main(String[] args) {

        Integer arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = Arrays.asList(arr);

        Map<Long, BigDecimal> strategyMap = new HashMap();
        strategyMap.put(1L, new BigDecimal(0.1));
        strategyMap.put(2L, new BigDecimal(0.3));
        strategyMap.put(3L, new BigDecimal(0.4));
        strategyMap.put(4L, new BigDecimal(0.2));

        Map<Long, List<Integer>> resultMap = new HashMap();
        resultMap.put(1L, new ArrayList<>());
        resultMap.put(2L, new ArrayList<>());
        resultMap.put(3L, new ArrayList<>());
        resultMap.put(4L, new ArrayList<>());

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            strategyMap.entrySet().stream().forEach(e -> {
                List<Integer> partitionList = resultMap.get(e.getKey());
                if (partitionList == null) {
                    partitionList = new ArrayList<>();
                }
                if (partitionList.size() < e.getValue().doubleValue() * list.size()) {
                    partitionList.add(iterator.next());
                }

            });
        }

        System.out.println(JSONObject.toJSONString(list));

    }
}
