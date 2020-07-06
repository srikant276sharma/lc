66. Plus One [E]
https://leetcode.com/problems/plus-one/

/* Solution 1: Using Math.

TC: O(n), where n is length of input array.
SC: O(n).
*/

class Solution {
    public int[] plusOne(int[] digits) {
        //we can have 3 cases: 123, 129, 999.
        int len = digits.length;
        for (int i = len - 1; i >= 0; i--) {
            if (9 == digits[i]) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        /*To handle a scenario where all digits are 9 like 99... */
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
