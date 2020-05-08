5. Longest Palindromic Substring [M]
https://leetcode.com/problems/longest-palindromic-substring/submissions/

/* Solution 1:
Koushik: https://www.youtube.com/watch?v=DK5OKKbF6GI

Time complexity: O(n^2). Need to check.
Space complexity: O(1).

Asked by:
*/

class Solution {
    int resultStart = 0, resultLength = 0;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        for (int start = 0; start < len; start++) {
            helper(s, start, start); //For odd length palindrome string.
            helper(s, start, start + 1); //For even length palindrome string.
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private void helper(String s, int begin, int end) {
        while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
            begin--;
            end++;
        }

        if (end - begin - 1 > resultLength) {
            resultLength = end - begin - 1; //Because our result (b>> aba <<d) lies in between begin and end, so subtracting 1.
            resultStart = begin + 1; //Because in the last iteration, we decremented 'begin'.
        }
    }
}
