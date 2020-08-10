171. Excel Sheet Column Number [E]
https://leetcode.com/problems/excel-sheet-column-number/

/* Solution 1:

TC: O(n), where n is the number of characters in the String.
SC: O(1).
*/

class Solution {
    public int titleToNumber(String s) {
        int result = 0;
        for (char c : s.toCharArray()) {
            int d = c - 'A' + 1;
            result = result * 26 + d;
        }
        return result;
    }
}
