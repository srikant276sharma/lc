1143. Longest Common Subsequence [M]
https://leetcode.com/problems/longest-common-subsequence/

/* Solution 1: Using Dynamic Programming.
Tushar: https://www.youtube.com/watch?v=NnD96abizww
B2B: https://www.youtube.com/watch?v=ASoaQq66foQ
     https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/LongestCommonSubsequence/BottomUp.java
Knowledge Center: https://www.youtube.com/watch?v=i1u2ChnUvZM

Time complexity: O(mn).
Space complexity: O(mn).

Similar:
1035. Uncrossed Lines [M]
*/

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int t1Len = text1.length();
        int t2Len = text2.length();
        int[][] lcs = new int[t1Len + 1][t2Len + 1];

        for (int i = 1; i <= t1Len; i++) {
            for (int j = 1; j <= t2Len; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }

        return lcs[t1Len][t2Len];
    }
}

--
Asked by:
--
