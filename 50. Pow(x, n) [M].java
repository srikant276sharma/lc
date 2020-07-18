50. Pow(x, n) [M]
https://leetcode.com/problems/powx-n/

/*Solution 1: Using Math. Integer limit: -2^31 to 2^31 - 1
KC: https://www.youtube.com/watch?v=snOaKR2xgZg

TC: O(log n), where n is input power.
SC: O(1), at max recursive call stack can go upto 31 levels deep.
*/

class Solution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        return powerUtil(x, n);
    }

    private double powerUtil(double x, long n) {
        if (n == 1) {
            return x;
        } else if (n < 0) {
            return powerUtil(1 / x, -n); //REMEMBER: -n works only if n is long. Ex: n = -2147483648 (Integer.MIN_VALUE)
        }

        double result = powerUtil(x * x, n / 2); //REMEMBER.
        if (n % 2 == 1) {
            result *= x;
        }

        return result;
    }
}
