package com.leetcode.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are given an array items, where each items[i] = [typei, colori, namei] describes the type, color, and name of the ith item.
 * You are also given a rule represented by two strings, ruleKey and ruleValue.
 *
 * The ith item is said to match the rule if one of the following is true:
 *
 * ruleKey == "type" and ruleValue == typei.
 * ruleKey == "color" and ruleValue == colori.
 * ruleKey == "name" and ruleValue == namei.
 * Return the number of items that match the given rule.
 *
 *
 *
 * Example 1:
 *
 * Input: items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
 * Output: 1
 * Explanation: There is only one item matching the given rule, which is ["computer","silver","lenovo"].
 * Example 2:
 *
 * Input: items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
 * Output: 2
 * Explanation: There are only two items matching the given rule, which are ["phone","blue","pixel"] and ["phone","gold","iphone"]. Note that the item ["computer","silver","phone"] does not match.
 */
public class CountItemsMatchingARule_LC1773 {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int c = 0;
        int index = (ruleKey.equals("type")) ? 0 : (ruleKey.equals("color")) ? 1 : 2;
        for(List<String> arr : items){
            if(arr.get(index).equals(ruleValue))
                c++;
        }
        return c;
    }

    public int countMatches2(List<List<String>> items, String ruleKey, String ruleValue) {
        Map<String, Integer> type = new HashMap<>();
        Map<String, Integer> color = new HashMap<>();
        Map<String, Integer> name = new HashMap<>();
        for (List<String> item : items) {
            int typeVal = type.getOrDefault(item.get(0), 0);
            typeVal++;
            type.put(item.get(0), typeVal);

            int colorVal = color.getOrDefault(item.get(1), 0);
            colorVal++;
            color.put(item.get(1), colorVal);

            int nameVal = name.getOrDefault(item.get(2), 0);
            nameVal++;
            name.put(item.get(2), nameVal);
        }
        if (ruleKey.equals("type")){
            return type.getOrDefault(ruleValue, 0);
        } else if (ruleKey.equals("color")){
            return color.getOrDefault(ruleValue, 0);
        } else if (ruleKey.equals("name")){
            return name.getOrDefault(ruleValue, 0);
        } else {
            return 0;
        }
    }
}
