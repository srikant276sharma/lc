1009. Complement of Base 10 Integer [E]
https://leetcode.com/problems/complement-of-base-10-integer/

/* Solution 1: Using XOR and mask.
Knowledge center: https://www.youtube.com/watch?v=bG3Dg6Q5RRw

Time complexity: O(1)
Space complexity: O(1).
*/

class Solution {
    public int bitwiseComplement(int N) {
        if (N == 0) { //Example: 5 = 101
            return 1;
        }

        int numBits = (int) (Math.log(N) / Math.log(2)) + 1; //numBits = 2 + 1 = 3
        int mask = (1 << numBits) - 1; //mask = 1000 - 1 = 111
        return N ^ mask; //101 ^ 111 = 010 = 2
    }
}
