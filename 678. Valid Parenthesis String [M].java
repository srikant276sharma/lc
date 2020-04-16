678. Valid Parenthesis String [M]
https://leetcode.com/problems/valid-parenthesis-string/

/* Solution 1:
Knowledge Center: https://www.youtube.com/watch?v=2H9gMIIGyvY
*/

class Solution {
    public boolean checkValidString(String s) {
        if (s.isEmpty())
            return true;

        /*Traversing from left to check count of ')' */
        int balance = 0;
        for (Character c : s.toCharArray()) {
            if (c == ')')
                balance--;
            else
                balance++;

            if (balance < 0)
                return false;
        }

        /*It means Open and Close Parenthesis are balanced. */
        if (balance == 0)
            return true;

        /*Traversing from right to check count of '(' */
        balance = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(')
                balance--;
            else
                balance++;

            if (balance < 0)
                return false;
        }

        return true;
    }
}

--
Complexities:
Time: O(N), where N is number of Characters in the String.
Space: O(1).
--
Asked by:
--
