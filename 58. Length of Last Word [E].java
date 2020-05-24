58. Length of Last Word [E]
https://leetcode.com/problems/length-of-last-word/

/* Solution 1:

Time complexity: O(n), where n is length of input string.
Space complexity: O(m), where m is length of the last word.

Asked by:
*/

class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null) {
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            //skip all empty characters which are present at the end of the input string.
            if (s.charAt(i) == ' ') {
                if (sb.length() != 0) {
                    return sb.length(); //applicable in such cases: "Hello World        "
                }
            } else {
                //add all characters of the last word.
                sb.append(s.charAt(i));
            }
        }

        return sb.length(); //applicable in such cases: "a", "   "
    }
}
