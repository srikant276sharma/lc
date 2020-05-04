476. Number Complement [E]
https://leetcode.com/problems/number-complement/

/* Solution 1: Using XOR and mask.
Knowledge center: https://www.youtube.com/watch?v=bG3Dg6Q5RRw

Time complexity: O(1)
Space complexity: O(1).
*/

class Solution {
    public int findComplement(int num) {
        if (num == 0) { //num = 5, Binary: 101
            return 1;
        }

        int numBits = (int) (Math.log(num) / Math.log(2)) + 1; //numBits = 2 + 1 = 3
        int mask = (1 << numBits) - 1; //mask = 1000 - 1 = 111
        return num ^ mask; //101 ^ 111 = 010 = 2
    }
}
