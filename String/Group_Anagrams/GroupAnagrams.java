package com.problem_solving.String.Group_Anagrams;

//Given an array of strings strs, group the anagrams together.
// You can return the answer in any order.

//Example 1:
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

//Explanation:
//There is no string in strs that can be rearranged to form "bat".
//The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

//Example 2:
//Input: strs = [""]
//Output: [[""]]

//Example 3:
//Input: strs = ["a"]
//Output: [["a"]]


import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            if (map.containsKey(sortedWord)) {
                map.get(sortedWord).add(word);
            }

        }
        List<List<String>> result = new ArrayList<>(map.values());
        return result;
    }

}
