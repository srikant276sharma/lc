520. Detect Capital [E]
https://leetcode.com/problems/detect-capital/

/* Solution 1:
KC: https://www.youtube.com/watch?v=qNJYp8aOpHQ

TC: O(n), Single pass.
SC: O(1), Constant space needed.

Asked by: Google.
*/

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() < 2) {
            return true;
        }

        if (Character.isUpperCase(word.charAt(0)) && Character.isUpperCase(word.charAt(1))) {
            for (int i = 2; i < word.length(); i++) {
                if (Character.isLowerCase(word.charAt(i))) {
                    return false;
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (Character.isUpperCase(word.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
