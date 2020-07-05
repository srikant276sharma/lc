461. Hamming Distance [E]
https://leetcode.com/problems/hamming-distance/

/* Solution 1: Using XOR operation.
Algorithm:
1. XOR has a value of 1 only when 2 bits are different.
2. Then count the 1's.

TC: O(1).
SC: O(1).

Asked by: Amazon, Facebook.
*/

class Solution {
    public int hammingDistance(int x, int y) {
        int res = x ^ y;
        int count = 0;

        for (int i = 0; i < 32; i++) {
            if ((res & 1) == 1) {
                count++;
            }
            res = res >> 1;
        }

        return count;
    }
}

/* Solution 2: Using XOR operation.
*/

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
