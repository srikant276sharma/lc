package com.interview;

import java.util.Arrays;
import java.util.Comparator;

/*
Arrange the values in lexicographically in java?
[1,2,3,10, 315] to [1,10,2,3, 315]
[1, 2, 3, 10, 315, 4, 40, 5, 211, 450, 2, 314, 31] to [1, 10, 2, 2, 211, 3, 31, 314, 315, 4, 40, 450, 5]
 * */
public class TestClass {

    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 10, 315, 4, 40, 5, 211, 450, 2, 314, 31};
        System.out.println(Arrays.toString(lexicographicalSort(input)));
    }

    public static Integer[] lexicographicalSort(Integer[] input) {
        Arrays.sort(input, new LexicographicalComparator());
        return input;
    }

    private static class LexicographicalComparator implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            String s1 = String.valueOf(o1);
            String s2 = String.valueOf(o2);
            return s1.compareTo(s2);
        }
    }
}
