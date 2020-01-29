191. Number of 1 Bits
https://leetcode.com/problems/number-of-1-bits/

--Solution 1:

class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            /* Below multiplication always sets the last 1 to 0 and loop iterates only count of 1's times. */
            n = n & (n - 1);
            count++;
        }
        return count;
    }
}
--
Time complexity: O(n) where n is the number of 1's.
Space complexity: O(1), since no additional space is allocated.
--
Implementation Details:
Use while (n != 0) instead of while (n > 0) since n can be a negative number.
--
