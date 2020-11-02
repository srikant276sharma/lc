Shortest Common Supersequence [M]

/* Solution 1: Type: LCS.
https://practice.geeksforgeeks.org/problems/shortest-common-supersequence/0#

Aditya: https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=24

TC: O(R * C), where R = length of string 1, C = length of string 2.
SC: O(R * C), required to make dp table.
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        
        for (int i = 0; i < tc; i++) {
            String str1 = sc.next(), str2 = sc.next();
            int res = shortestCommonSuperseq(str1, str2);
            System.out.println(res);
        }
        sc.close();
    }
    
    private static int shortestCommonSuperseq(String str1, String str2) {
        int l1 = str1.length(), l2 = str2.length();
        int[][] dp = new int[l1 + 1][l2 + 1]; //added an extra row and column for 0.
        
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //total length - length of LCS.
        return l1 + l2 - dp[l1][l2];
    }
}
