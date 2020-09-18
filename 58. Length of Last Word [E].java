58. Length of Last Word [E]
https://leetcode.com/problems/length-of-last-word/

/* Solution 1:

Time complexity: O(n), where n is length of input string.
Space complexity: O(m), where m is length of the last word.

Asked by:
*/

class Solution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        if (s == null || s.length() == 0) {
            return len;
        }
        
        int n = s.length(); 
        while (--n >= 0) {
            if (s.charAt(n) != ' ') {
                len++;
            } else if (len > 0 && s.charAt(n) == ' ') {
                break;
            }
        }
        return len;
    }
}
