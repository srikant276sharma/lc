1470. Shuffle the Array [E]
https://leetcode.com/problems/shuffle-the-array/

/* Solution 1:

TC: O(n), where n is L/2. L is the length of input array. 
SC: O(L), to keep output array.

Asked by:
*/

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            res[j++] = nums[i];
            res[j++] = nums[n + i];
        }
        return res;
    }
}
