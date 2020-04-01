136. Single Number [E]
https://leetcode.com/problems/single-number/
Kevin: https://www.youtube.com/watch?v=CvnnCZQY2A0

/*Solution 1: 
  Using XOR operation.
*/

class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}

--
Time complexity:  O(n), where n is number of elements in the array.
Space complexity: O(1).
--
Asked by: Amazon, Google, Alibaba.
--
