231. Power of Two [E]
https://leetcode.com/problems/power-of-two/

/* Solution 3: Using Bit Operation. AND between n and (n-1) should be equal to 0.
TC: O(1).
SC: O(1).
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && (n & (n - 1)) == 0;
    }
}

/*Solution 1: Using multiplication.
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        long i = 1;
        while (i < n) {
            i *= 2;
        }
        return i == n;
    }
}

/*Solution 2: Loop Iteration
 Algorithm:
 One simple way of finding out if a number n is a power of a number b is to keep dividing n by b as long as the remainder is 0.
 The end result to be 1.
 This algorithm works for any "Power of X" question for X = 2, 3, 4,...

Notice that we need a guard to check that n != 0, otherwise the while loop will never finish. 
For negative numbers, the algorithm does not make sense, so we will include this guard as well.
--
TC: O(logb​(n)). In our case that is O(log2n). The number of divisions is given by that logarithm.
SC: O(1). We are not using any additional memory.
--
Asked by: Amazon
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
