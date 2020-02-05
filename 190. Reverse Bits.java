190. Reverse Bits
https://leetcode.com/problems/reverse-bits/
--

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res << 1) | (n & 1);
            n >>= 1;
        }
        return res;
    }
}
--
Time complexity: O(n).
Space complexity: O(1).
--
