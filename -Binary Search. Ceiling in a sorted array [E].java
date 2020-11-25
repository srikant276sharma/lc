Ceiling in a sorted array [E]

/* Solution 1: Type: Binary Search.
https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/

Aditya: https://www.youtube.com/watch?v=uiz0IxPCUeU&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=11

TC: O(log n).
SC: O(1).
*/

import java.util.*;

public class MyClass {
    public static void main(String args[]) {
        int[] nums = new int[]{1, 2, 8, 10, 10, 12, 19};
        int x = 5; //output: 8
        int ceil = solve(nums, x);
        System.out.println(ceil);
    }

    //Ceiling in a sorted array.
    private static int solve(int[] nums, int x) {
        int left = 0, right = nums.length - 1;
        int res = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == x) {
                res = nums[mid];
                break;
            } else if (nums[mid] < x) {
                left = mid + 1;
            } else { //while going left to find smaller element, update res.
                res = nums[mid]; //nums[mid] is a possible candidate.
                right = mid - 1;
            }
        }
        return res;
    }
}
