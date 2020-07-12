190. Reverse Bits [E]
https://leetcode.com/problems/reverse-bits/

/*Solution 1: Using Left Shift, OR, AND and Right Shift bitwise operators.

TC: O(1).
SC: O(1).
*/

class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            /* At first left shift res then OR with result of (n & 1) */
            res = res << 1;
            res = res | (n & 1);
            n = n >> 1;
        }

        return res;
    }
}
