Is str1 a subsequence of str2? [M]

/* Solution 1: Type: LCS.

Aditya: https://www.youtube.com/watch?v=QVntmksK2es&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=31

TC: O(R * C), where R = length of string 1, C = length of string 2.
SC: O(R * C), required to make dp table.
*/

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String s1 = "axy", s2 = "adxcpy";
        System.out.println(main.isSubsequence(s1, s2)); //output: true. 
    }
    //Is s1 a subsequence of s2?
    public static boolean isSubsequence(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        //check if length of s1 = length of LCS.
        return (l1 == dp[l1][l2]) ? true : false;
    }
}
