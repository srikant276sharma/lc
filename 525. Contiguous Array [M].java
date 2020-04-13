525. Contiguous Array [M]
https://leetcode.com/problems/contiguous-array/

/* Solution 1: Using HashMap.

 index: -1 [ 0  1  2  3  4  5  6  7]
 input:    [ 0  0  1  0  0  0  1  1]
 value:  0 [-1 -2 -1 -2 -3 -4 -3 -2]

 In map, if we encounter the same value twice, it means the number of 0's and the number of 1's are equal between Current Index (j) and Previous Index (i).
 The largest subarray corresponds to the largest j-i where value[i] == value[j].
 In this case, i=1, j=7, value[i] == value[j] == -2, and j-i = 7-1 = 6.
 This corresponds to subarray [i, j] which is [1, 0, 0, 0, 1, 1]
 */

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        /*Index starts from 0, so to get actual length, initializing map with (Value 0 : Index -1) */
        valueIndexMap.put(0, -1);
        int maxLength = 0;
        int value = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                value--; /*In case of 0, -1. */
            } else {
                value++; /*In case of 1, +1. */
            }

            /*If we encounter the same 'value' twice, it means the number of 0's and the number of 1's are equal between Current Index and Previous Index.
             * So, Contiguous array max length = Current Index - Previous Index.
             * */
            if (valueIndexMap.containsKey(value)) {
                maxLength = Math.max(maxLength, i - valueIndexMap.get(value));
            } else {
                valueIndexMap.put(value, i);
            }
        }

        return maxLength;
    }
}

--
Complexities:
Time: O(N), The entire array is traversed only once.
Space: O(N), Maximum size of the HashMap will be n, if all the elements are either 1 or 0.
--
Asked by:
--
