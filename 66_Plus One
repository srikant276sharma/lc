66. Plus One
https://leetcode.com/problems/plus-one/
--
class Solution {
    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if (9 == digits[i]) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        /*To handle a scenario where all digits are 9 like 99... */
        int[] arr = new int[digits.length + 1];
        arr[0] = 1;
        return arr;
    }
}
--
