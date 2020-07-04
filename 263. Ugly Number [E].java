263. Ugly Number [E]
https://leetcode.com/problems/ugly-number/

/* Solution 1: Using modulus and division.
Ugly numbers are positive numbers whose prime factors ONLY INCLUDE 2, 3, 5.

To find ugly numbers, we remove all factors of 2, 3, and 5 using division. 
If the end result is 1, then the original input was an ugly number.

TC: O(log2 (n)), where n is the input number, because log base 2 will be higher than log base 3 and log base 5.
SC: O(1).
*/

class Solution {
    public boolean isUgly(int num) {
        if (num < 1) {
            return false;
        }
        
        int[] divisors = new int[]{2, 3, 5};
        for (int divisor : divisors) {
            while (num % divisor == 0) {
                num /= divisor;
            }
        }

        return num == 1;
    }
}
