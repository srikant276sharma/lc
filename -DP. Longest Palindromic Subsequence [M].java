Longest Palindromic Subsequence [M]

/* Solution 1: Type: LCS.
https://www.geeksforgeeks.org/longest-palindromic-subsequence-dp-12/

Aditya: https://www.youtube.com/watch?v=wuOOOATz_IA&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26

TC: O(R * C), where R = length of string 1, C = length of string 2.
SC: O(R * C), required to make dp table.
*/

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.longestPalinSubsequence("geeksforgeeks")); //output: 5
    }
    //Longest Palindromic Subsequence.
    //LPS(str) ~ LCS(str, reverse(str)).
    private static int longestPalinSubsequence(String str) {
        StringBuilder sb = new StringBuilder(str);
        String str2 = sb.reverse().toString();
        int l1 = str.length(), l2 = str2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
