338. Counting Bits [M]
https://leetcode.com/problems/counting-bits/

/* Solution 1: Using >> Bit operation.
Knowledge Center: https://www.youtube.com/watch?v=iuqr5hHk2MI&t=20s

Time complexity: O(n).
Space complexity: O(n).

Asked by:
*/

class Solution {
    public int[] countBits(int num) {
        int[] bitCounts = new int[num + 1]; //because 0 is also included.

        for (int i = 1; i <= num; i++) {
            bitCounts[i] = bitCounts[i >> 1] + i % 2; //Right shift by 1 make input number half.
        }

        return bitCounts;
    }
}
