package com.leetcode.medium;

import com.leetcode.common.SortedList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Sorted List Implementation
 *
 * Create a timebased key-value store class TimeMap, that supports two operations.
 *
 * 1. set(string key, string value, int timestamp)
 *
 * Stores the key and value, along with the given timestamp.
 * 2. get(string key, int timestamp)
 *
 * Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
 * If there are multiple such values, it returns the one with the largest timestamp_prev.
 * If there are no values, it returns the empty string ("").
 *
 *
 * Example 1:
 *
 * Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
 * Output: [null,null,"bar","bar",null,"bar2","bar2"]
 * Explanation:
 * TimeMap kv;
 * kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1
 * kv.get("foo", 1);  // output "bar"
 * kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"
 * kv.set("foo", "bar2", 4);
 * kv.get("foo", 4); // output "bar2"
 * kv.get("foo", 5); //output "bar2"
 */
class TimeMap_LC981 {

    /**
     * Use floorKey of TreeMap to get the result
     */
    static class Best {
        private Map<String, TreeMap<Integer,String>> map;

        /** Initialize your data structure here. */
        public Best() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            if(!map.containsKey(key)) {
                map.put(key,new TreeMap<>());
            }
            map.get(key).put(timestamp,value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer,String> treeMap = map.get(key);
            if(treeMap==null) {
                return "";
            }
            Integer floor = treeMap.floorKey(timestamp);
            if(floor==null) {
                return "";
            }
            return treeMap.get(floor);
        }
    }

    public static class TimeValue implements Comparable<TimeValue> {
        int timestamp;
        String value;
        TimeValue(int timestamp, String value){
            this.timestamp = timestamp;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (o == this) return true;
            if (!(o instanceof TimeValue)) {
                return false;
            }
            TimeValue t = (TimeValue) o;
            return timestamp == t.timestamp;
        }

        //Idea from effective Java : Item 9
        @Override
        public int hashCode() {
            int result = 17;
            result = 31 * result + timestamp;
            return result;
        }

        @Override
        public int compareTo(TimeValue o) {
            TimeValue t = (TimeValue) o;
            return Integer.compare(timestamp, t.timestamp);
        }
    }

    Map<String, List<TimeValue>> timeMap;
    /** Initialize your data structure here. */
    public TimeMap_LC981() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TimeValue t = new TimeValue(timestamp, value);
        List<TimeValue> list = timeMap.getOrDefault(key, new SortedList<>());
        list.add(t);
        timeMap.put(key, list);
    }

    public String get(String key, int timestamp) {
        if (timeMap.containsKey(key)){
            List<TimeValue> list = timeMap.get(key);
            int index = Collections.binarySearch(list, new TimeValue(timestamp, null));
            if (index >= 0) { // actual key found
                return list.get(index).value;
            } else {
                index = Math.abs(index) - 1;
                if (index >= list.size()) {
                    return list.get(list.size() -1).value;
                } else if (index == 0) { // less than 0th index
                    return "";
                } else { // lower value returned than insertion point
                    return list.get(index - 1).value;
                }
            }
        } else {
            return "";
        }
    }
}
