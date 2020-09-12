42. Trapping Rain Water [H]
https://leetcode.com/problems/trapping-rain-water/

/* Solution 1: Using 2 pointers.
Amell: https://www.youtube.com/watch?v=ZanjlzDaFoI

TC: O(N), where N is length of input array.
SC: O(1).
*/

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0, maxLowerLevel = 0, l = 0, r = height.length - 1;

        while (l < r) {
            int curLower = height[height[l] < height[r] ? l++ : r--];
            maxLowerLevel = Math.max(maxLowerLevel, curLower);
            res += maxLowerLevel - curLower;
        }
        return res;
    }
}
