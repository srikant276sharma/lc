704. Binary Search [E]
https://leetcode.com/problems/binary-search/

/* Solution 1: Using Binary Search.

TC: O(logN), where N is the length of input array.
SC: O(1).
*/

class Solution {
    public int search(int[] nums, int target) {
        //input check.
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
