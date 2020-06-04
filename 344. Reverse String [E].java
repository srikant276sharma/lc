344. Reverse String [E]
https://leetcode.com/problems/reverse-string/

/* Solution 1: Using 2 pointers approach. 

TC: O(n).
SC: O(1).

Asked by:
*/

class Solution {
    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;

        while (i < j) {
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }
}

