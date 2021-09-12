34. Find First and Last Position of Element in Sorted Array [M]
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

/* Solution 1: Using Binary Search.
Aditya

Time: O(log n).
Space: O(1).

Asked by: Facebook.
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
         int firstPos = binSearch(nums, target, true);
         int lastPos = binSearch(nums, target, false);
        return new int[]{firstPos, lastPos};
    }

    private int binSearch(int[] nums, int target, boolean isFirstPos) {
        int low = 0, high = nums.length - 1, res = -1;
    
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid]) {
                res = mid;
                if (isFirstPos) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }
}
