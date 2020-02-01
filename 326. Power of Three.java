326. Power of Three
https://leetcode.com/problems/power-of-three/

--Solution 1:

public class Solution {
    public boolean isPowerOfThree(int n) {
        long i = 1;
        while (i < n) {
            i *= 3;
        }
        return i == n;
    }
}

-- Solution 2: Loop Iteration
/**
 * Algorithm:
 * One simple way of finding out if a number n is a power of a number b is to keep dividing n by b as long as the remainder is 0.
 * The end result to be 1.
 * This algorithm works for any "Power of X" question for X = 2, 3, 4,...
 */

class Solution {
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return 1 == n;
    }
}
--
Notice that we need a guard to check that n != 0, otherwise the while loop will never finish. 
For negative numbers, the algorithm does not make sense, so we will include this guard as well.
--
Complexity Analysis
Time complexity: O(logb​(n)). In our case that is O(log3​n). The number of divisions is given by that logarithm.
Space complexity: O(1). We are not using any additional memory.
--
Amazon
-- 
Runtime: 11 ms, faster than 90.63% of Java online submissions for Power of Three.
Memory Usage: 40.8 MB, less than 6.25% of Java online submissions for Power of Three.
--
