844. Backspace String Compare [E]
https://leetcode.com/problems/backspace-string-compare/

/* Solution 1:
Using StringBuilder.
Amell: https://www.youtube.com/watch?v=3DlKpeZywMs
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return processBackspace(S).equals(processBackspace(T));
    }

    private String processBackspace(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}


/* Solution 2:
Using Stack.
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        return processBackspace(S).equals(processBackspace(T));
    }

    private String processBackspace(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c != '#') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        return String.valueOf(stack);
    }
}

--
Time Complexity: O(n), where n is number of Characters in the String.
Space Complexity: O(n), where n is number of Characters in the String.
--

/*
Using skip counter.
*/

class Solution {
    public boolean backspaceCompare(String S, String T) {
        int sIndex = S.length() - 1, tIndex = T.length() - 1;
        int skipS = 0, skipT = 0;

        /*While there may be characters in build(S) or build(T). */
        while (sIndex >= 0 || tIndex >= 0) {
            /*Find index of next possible character in build(S). */
            while (sIndex >= 0) {
                /*If current char is #, increment skip counter skipS. */
                if (S.charAt(sIndex) == '#') {
                    skipS++;
                    sIndex--;
                } else if (skipS > 0) {
                    /*Skip 'skipS' characters. */
                    skipS--;
                    sIndex--;
                } else
                    break;
            }

            /*Find index of next possible character in build(T). */
            while (tIndex >= 0) {
                /*If current character is #, increment skip counter skipT. */
                if (T.charAt(tIndex) == '#') {
                    skipT++;
                    tIndex--;
                } else if (skipT > 0) {
                    /*Skip 'skipT' characters. */
                    skipT--;
                    tIndex--;
                } else
                    break;
            }

            /*If two actual characters are different. */
            if (sIndex >= 0 && tIndex >= 0 && (S.charAt(sIndex) != T.charAt(tIndex))) {
                return false;
            }
            /*To check a scenario like sIdx = 0 and tIdx = -1. Example: "bxj##tw", "bxj###tw" */
            if ((sIndex >= 0) != (tIndex >= 0)) {
                return false;
            }
            sIndex--;
            tIndex--;
        }

        return true;
    }
}

--
Time Complexity: O(n), where n is number of Characters in the String.
Space Complexity: O(1).
--
Asked by: Google, Facebook.
--
