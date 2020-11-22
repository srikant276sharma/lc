package com.marc.dsa;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GFG {
    public static void main(String args[]) throws IOException {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(12);
        nums.add(1);
        nums.add(4);
        sort(nums);
        System.out.print(nums);
    }

    private static void sort(List<Integer> nums) {
        //base condition: there is no need to sort an array of length 1.
        if (nums.size() == 1) {
            return;
        }
        //hypothesis.
        int lastNum = nums.get(nums.size() - 1);
        nums.remove(nums.size() - 1);
        sort(nums); //reduced nums size.
        //induction.
        insert(nums, lastNum);
    }

    private static void insert(List<Integer> nums, int lastNum) {
        //base condition: either list is empty or last element is <= lastNum.
        if (nums.size() == 0 || nums.get(nums.size() - 1) <= lastNum) {
            nums.add(lastNum);
            return;
        }
        //hypothesis.
        int last = nums.get(nums.size() - 1);
        nums.remove(nums.size() - 1);
        insert(nums, lastNum);
        //induction.
        nums.add(last);
    }
}
