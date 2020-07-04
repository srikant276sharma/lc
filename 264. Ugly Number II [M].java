264. Ugly Number II [M]
https://leetcode.com/problems/ugly-number-ii/

/* Solution 1: Using Dynamic Programming.
KC: https://www.youtube.com/watch?v=kSDI_iOiGQY

Ugly numbers are positive numbers whose prime factors ONLY INCLUDE 2, 3, 5.
--
To find ugly numbers, we remove all factors of 2, 3, and 5 using division. 
If the end result is 1, then the original input was an ugly number.
--
TC: O(N), where N is the input number.
SC: O(N).
*/

class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1; //Base Case.
        int count = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;

        while (count < n) {
            int nm2 = ugly[idx2] * 2, nm3 = ugly[idx3] * 3, nm5 = ugly[idx5] * 5;
            int minNext = Math.min(nm2, Math.min(nm3, nm5));

            ugly[count++] = minNext;

            if (minNext == nm2) {
                idx2++;
            }
            if (minNext == nm3) {
                idx3++;
            }
            if (minNext == nm5) {
                idx5++;
            }
        }

        return ugly[n - 1];
    }
}
