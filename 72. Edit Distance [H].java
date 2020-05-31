72. Edit Distance [H]
https://leetcode.com/problems/edit-distance/

/* Solution 1: Using Top-Down Dynamic Programming.

B2B: https://www.youtube.com/watch?v=MiqoA-yF-0M
Knowledge Center: https://www.youtube.com/watch?v=ZkgBinDx9Kg&t=189s           

Time complexity: O(MN), where M and N are lengths of word1 and word2.
Space complexity: O(MN).

Asked by:
*/

class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length(), l2 = word2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];

        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0) { //First row.
                    dp[i][j] = j;
                } else if (j == 0) { //First column.
                    dp[i][j] = i;
                } else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    //if both characters match then don't make any change in the Edit distance.
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //top left (replace), top (insert), left (delete)
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }

        return dp[l1][l2];
    }
}
