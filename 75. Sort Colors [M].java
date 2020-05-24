75. Sort Colors [M]
https://leetcode.com/problems/sort-colors/

/* Solution 1: Using 2 pointers.
Nick: https://www.youtube.com/watch?v=uvB-Ns_TVis

Time complexity: O(n), where n is length of input array.
Space complexity: O(1).

Asked by:
*/

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int start = 0, //point to the index where next 0 will go.
                end = nums.length - 1, //point to the index where next 2 will go.
                cur = 0;

        while (cur <= end) {
            if (nums[cur] == 0) {
                nums[cur] = nums[start];
                nums[start] = 0;
                start++;
                cur++; //eg. 1, 0. cur is processing '0'. after processing both 0 and 1 are processed so increment cur.
            } else if (nums[cur] == 2) {
                nums[cur] = nums[end];
                nums[end] = 2;
                end--;
                //we need to process the item which replaced cur item so didn't increment cur.
            } else {
                cur++; //in case of 1, just increment the cur to process the next item.
            }
        }
    }
}
