35. Search Insert Position [E]
https://leetcode.com/problems/search-insert-position/

/* Solution 1: Using Binary Search.

TC: O(log n), where n is the length of the input array.
SC: O(1).

Asked by:
*/

class Solution {
    public int searchInsert(int[] nums, int target) {
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

        return left;
    }
}
