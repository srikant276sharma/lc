9. Palindrome Number
https://leetcode.com/problems/palindrome-number/

--Solution 1:
/**
 without converting the integer to a string.
*/
--
class Solution {
    public boolean isPalindrome(int x) {
        /* If x is negative or if it ends with 0 then it can't be a Palindrome. */
        if (x < 0 || (x > 0 && x % 10 == 0)) {
            return false;
            /* Single digit is always Palindrome. */
        } else if (x < 10) {
            return true;
        } else {
            /* If input value and reversed value are same then it's a Palindrome. */
            int input = x;
            int rev = 0;
            while (input != 0) {
                int pop = input % 10;
                rev = rev * 10 + pop;
                input /= 10;
            }
            return rev == x;
        }
    }
}
--
Time Complexity: O(n) where n is the number of digits.
Space Complexity: O(1).

--Solution 2:
class Solution {
    public boolean isPalindrome(int x) {
        // Special cases:
        // when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome, the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palindrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
--
Time complexity: O(log⁡10(n)). We divided the input by 10 for every iteration, so the time complexity is O(log⁡10(n)).
Space complexity: O(1).
--
