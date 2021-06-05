1143. Longest Common Subsequence [M]
https://leetcode.com/problems/longest-common-subsequence/

/* 
Aditya: Best explanation.
Tushar: https://www.youtube.com/watch?v=NnD96abizww
B2B: https://www.youtube.com/watch?v=ASoaQq66foQ
     https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/LongestCommonSubsequence/BottomUp.java
Knowledge Center: https://www.youtube.com/watch?v=i1u2ChnUvZM

Time complexity: O(mn).
Space complexity: O(mn).

Similar:
1035. Uncrossed Lines [M]
*/

/* Using dynamic programming. */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                //initialization.
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                //choice diagram.
                if (i > 0 && j > 0) {
                    if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                        dp[i][j] = 1 + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[m][n];
    }
}

/* Using recursion. */

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        //recursive call.
        return lcs(text1, m, text2, n);
    }
    
    private int lcs(String text1, int m, String text2, int n) {
        //base case.
        if (m == 0 || n == 0) {
            return 0;
        }
        //choice diagram.
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) { //if chars match.
            return 1 + lcs(text1, m - 1, text2, n - 1);
        } else {
            return Math.max(lcs(text1, m - 1, text2, n), lcs(text1, m, text2, n - 1));
        }
    }
} 
