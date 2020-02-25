1281. Subtract the Product and Sum of Digits of an Integer
https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

/*
*/

/*Solution 1.
1. use 'num % 10' to get the last digit.
*/
 
class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0;
        int product = 1;
        while (n > 0) {
            int pop = n % 10;
            sum += pop;
            product *= pop;
            n /= 10;
        }
        return product - sum;
    }
}

--
Time complexity: O(n) where n is the no. of digits.
Space complexity: O(1).
--
Asked by:.
--
