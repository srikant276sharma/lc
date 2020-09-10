8. String to Integer (atoi)
https://leetcode.com/problems/string-to-integer-atoi/
--
class Solution {
    public int myAtoi(String str) {
        str = str.trim();
        /* Empty str and Only whitespace characters check. */
        if (str.isEmpty()) {
            return 0;
        }

        char[] chArr = str.toCharArray();
        int i = 0;
        /* Optional sign check and increment the index. */
        boolean isNegative = false;
        if (chArr[i] == '+') {
            i++;
        } else if (chArr[i] == '-') {
            isNegative = true;
            i++;
        }

        int res = 0;
        /* Numeric check. */
        for (; i < chArr.length && chArr[i] >= '0' && chArr[i] <= '9'; i++) {
            int num = chArr[i] - '0';
            num = isNegative ? -num : num;
            /* Out of range check. */
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && num > 7)) {
                return Integer.MAX_VALUE;
            } else if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && num < -8)) {
                return Integer.MIN_VALUE;
            } else {
                res = res * 10 + num;
            }
        }
        return res;
    }
}
--
Runtime: 1 ms, faster than 100.00% of Java online submissions for String to Integer (atoi).
Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for String to Integer (atoi).
--
