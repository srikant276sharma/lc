package com.marc.dsa;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * Generate all permutations of string in lexicographically sorted order where repetitions of character is possible in string.
 * Input: "ABC"
 * Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
 * Tushar: https://github.com/mission-peace/interview/blob/master/src/com/interview/recursion/StringPermutation.java
 * */

public class StringPermutation {

    public static void main(String[] args) {
        StringPermutation sp = new StringPermutation();
        sp.permute("ABC").forEach(s -> System.out.println(s));
    }

    private List<String> permute(String input) {
        Map<Character, Integer> characterCountMap = new TreeMap<>();
        for (Character c : input.toCharArray()) {
            characterCountMap.put(c, characterCountMap.getOrDefault(c, 0) + 1);
        }

        char[] chars = new char[characterCountMap.size()];
        int[] counts = new int[characterCountMap.size()];
        int index = 0;

        for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
            chars[index] = entry.getKey();
            counts[index] = entry.getValue();
            index++;
        }

        List<String> resultList = new ArrayList<>();
        char[] result = new char[input.length()];
        permuteUtil(chars, counts, result, 0, resultList);

        return resultList;
    }

    private void permuteUtil(char[] chars, int[] counts, char[] result, int level, List<String> list) {
        if (level == result.length) {
            list.add(new String(result));
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (counts[i] == 0)
                continue;

            result[level] = chars[i];
            counts[i]--;
            permuteUtil(chars, counts, result, level + 1, list);
            counts[i]++;
        }
    }

}

/*
Time Complexity: O(n!), because we can have n! permutations, where n is number of characters in the input string.
Space Complexity: 
O(n!), because we are storing the result in a list.
O(n), if we are not storing the output then it will be O(n) because we are going at max n level deep into the recursion.
*/
