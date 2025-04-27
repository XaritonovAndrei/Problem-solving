package com.problem_solving.Time_Based_KeyValue_Store;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

public class TimeMap {
    private Map<String, TreeMap<Integer, String>> map = new HashMap<>();

//    public TimeMap() {
//        map = new HashMap<>();
//    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = map.get(key);
        if (treeMap == null) return "";
        Map.Entry<Integer, String> mapEntry = treeMap.floorEntry(timestamp);
        if (mapEntry == null) return "";
        else return mapEntry.getValue();
    }

}
