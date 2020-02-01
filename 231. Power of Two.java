231. Power of Two
https://leetcode.com/problems/power-of-two/

--Solution 1:

class Solution {
    public boolean isPowerOfTwo(int n) {
        long i = 1;
        while (i < n) {
            i *= 2;
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
    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return 1 == n;
    }
}
--
Notice that we need a guard to check that n != 0, otherwise the while loop will never finish. 
For negative numbers, the algorithm does not make sense, so we will include this guard as well.
--
Complexity Analysis
Time complexity: O(logb​(n)). In our case that is O(log2n). The number of divisions is given by that logarithm.
Space complexity: O(1). We are not using any additional memory.
--
Amazon
-- 
Runtime: 1 ms, faster than 100.00% of Java online submissions for Power of Two.
Memory Usage: 37 MB, less than 7.32% of Java online submissions for Power of Two.
--
