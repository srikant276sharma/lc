392. Is Subsequence [E]
https://leetcode.com/problems/is-subsequence/

/* Solution 1: Using 2 pointers approach.

TC: O(N), where N is the length of string 't'.
SC: O(1).

Asked by:
*/

class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if (sLen > tLen) {
            return false;
        }

        int sIndex = 0, tIndex = 0;
        while (sIndex < sLen && tIndex < tLen) {
            //if characters match, increment both pointers, otherwise increment only tIndex.
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }

        return sIndex == sLen;
    }
}
