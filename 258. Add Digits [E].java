258. Add Digits [E]
https://leetcode.com/problems/add-digits/

/*Solution 1: Iterative approach, using modulo and division operations.

TC: O(n), where n is the input number.
SC: O(1).
*/

class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            num = addDigitsUtil(num);
        }
        return num;
    }

    private int addDigitsUtil(int num) {
        int sumOfDigits = 0;
        while (num > 0) {
            sumOfDigits += num % 10;
            num /= 10;
        }
        return sumOfDigits;
    }
}

/*Solution 1: Mathematical approach.
KC: https://www.youtube.com/watch?v=tIjdI-ioXh0&t=36s

TC: O(1).
SC: O(1).
*/

class Solution {
    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        } else if (num % 9 == 0) {
            return 9;
        } else {
            return num % 9;
        }
    }
}
