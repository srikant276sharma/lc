11. Container With Most Water [M]
https://leetcode.com/problems/container-with-most-water/

/* Solution 1: Using 2 pointer approach.
Kevin: https://www.youtube.com/watch?v=TI3e-17YAlc

Time: O(N), where N is number of elements in input array.
Space: O(1).

Asked by: Facebook, Google, Microsoft, Airbnb, Goldman Sachs, Alibaba, and Adobe.
*/

class Solution {
    public int maxArea(int[] height) {
        int maxArea = Integer.MIN_VALUE,
                i = 0,
                j = height.length - 1;

        while (i < j) {
            int minHeight = Math.min(height[i], height[j]);
            maxArea = Math.max(maxArea, minHeight * (j - i));
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return maxArea;
    }
}
