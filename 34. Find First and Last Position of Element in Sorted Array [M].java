34. Find First and Last Position of Element in Sorted Array [M]
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

/* Solution 1: Using Binary Search.
Errichto: https://www.youtube.com/watch?v=dVXy6hmE_0U

Time: O(log n).
Space: O(1).

Asked by: Facebook.
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = findFirstPosition(nums, target);
        int last = findFirstPosition(nums, target + 1) - 1; //Try to find the first position of an element which is greater than target.

        if (first <= last) {
            return new int[]{first, last};
        } else {
            return new int[]{-1, -1};
        }
    }

    private int findFirstPosition(int[] nums, int target) {
        int len = nums.length;
        int low = 0, high = len - 1, firstPos = len;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= target) {
                firstPos = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return firstPos;
    }
}
