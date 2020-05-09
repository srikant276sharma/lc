516. Longest Palindromic Subsequence [M]
https://leetcode.com/problems/longest-palindromic-subsequence/

/* Solution 1: Using Top Down Dynamic programming.
Tushar: https://www.youtube.com/watch?v=_nCsPn7_OgI&t=30s
        https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/LongestPalindromicSubsequence.java

Time complexity: O(n^2).
Space complexity: O(n^2).

Asked by:
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        //Fill diagonal elements with 1.
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }

        //Process all diagonal upper right elements diagonally.
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len - l + 1; i++) {
                int j = i + l - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2; //If both end characters match, then left down diagonal element + 2.
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]); //Max between left and down elements.
                }
            }
        }

        return dp[0][len - 1]; //Return top right corner value.
    }
}
