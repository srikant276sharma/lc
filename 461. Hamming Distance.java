461. Hamming Distance
https://leetcode.com/problems/hamming-distance/

--Solution 1:
Algorithm:
1. XOR has a value of 1 only when 2 bits are different.
2. Then count the 1's.
--
class Solution {
    public int hammingDistance(int x, int y) {
        int xorRes = x ^ y;
        /* Count the number of 1's. */
        int count = 0;
        while (xorRes != 0) {
            xorRes = xorRes & (xorRes - 1);
            count++;
        }
        return count;
    }
}
--
Time complexity: O(1).
Space complexity: O(1).
--
Adobe, Uber, Facebook, Aetion
-- 
Runtime: 0 ms, faster than 100.00% of Java online submissions for Hamming Distance.
Memory Usage: 37.5 MB, less than 5.09% of Java online submissions for Hamming Distance.
--
