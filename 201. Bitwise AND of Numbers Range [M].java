201. Bitwise AND of Numbers Range [M]
https://leetcode.com/problems/bitwise-and-of-numbers-range/

/* Solution 1: Using Bitwise AND, Left Shift and Right Shift.
Tech Dose: https://www.youtube.com/watch?v=-qrpJykY2gE
*/

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shiftCount = 0;

        /*Find leftmost consecutive common part. */
        while (m != n) {
            m >>= 1;
            n >>= 1;
            shiftCount++;
        }

        return m <<= shiftCount; //Add shiftCount zeroes.
    }
}

--
Complexities:
Time: O(1), since we have elements in int representation and we can have max 32 bits.
Space: O(1), we are not using any extra space.
--
Asked by:
--
