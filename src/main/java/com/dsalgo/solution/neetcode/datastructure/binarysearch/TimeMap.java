package com.dsalgo.solution.neetcode.datastructure.binarysearch;

import java.util.*;

public class TimeMap {

    private static class TimestampValue {
        String value;
        int timestamp;
        TimestampValue(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    private final Map<String, List<TimestampValue>> data;
    
    public TimeMap() {
        data = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!data.containsKey(key)) data.put(key, new ArrayList<>());
        data.get(key).add(new TimestampValue(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!data.containsKey(key)) return "";

        int left=0, right=data.get(key).size()-1;
        int res = -1;
        while(left <= right) {
            int mid = left + (right-left) / 2;
            if (data.get(key).get(mid).timestamp <= timestamp) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res == -1 ? "" : data.get(key).get(res).value;
    }
}
