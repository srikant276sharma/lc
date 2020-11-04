Printing Shortest Common Supersequence [H]

/* Solution 1: Type: LCS, SCS.
https://www.geeksforgeeks.org/print-shortest-common-supersequence/

Aditya: https://www.youtube.com/watch?v=VDhRg-ZJTuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=29

TC: O(R * C), where R = length of string 1, C = length of string 2.
SC: O(R * C), required to make dp table.
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String s1 = "AGGTAB", s2 = "GXTXAYB";
        System.out.println(main.shortestCommonSupersequence(s1, s2)); //output: "AGXGTXAYB" OR "AGGXTXAYB" 
    }
    //Printing Shortest Common Supersequence.
    private static String shortestCommonSupersequence(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        int[][] dp = new int[l1 + 1][l2 + 1]; //added an extra row and column for 0.
        
        //build LCS table.
        for (int i = 0; i <= l1; i++) {
            for (int j = 0; j <= l2; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        //print SCS.
        int m = l1, n = l2;
        StringBuilder sb = new StringBuilder();
        
        while (m > 0 && n > 0) {
            if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
                sb.append(s1.charAt(m - 1));
                m--;
                n--;
            } else {
                if (dp[m][n - 1] > dp[m - 1][n]) {
                    sb.append(s2.charAt(n - 1));
                    n--;
                } else {
                    sb.append(s1.charAt(m - 1));
                    m--;
                }
            }
        }
        
        while (m > 0) {
            sb.append(s1.charAt(m - 1));
            m--;
        }
        while (n > 0) {
            sb.append(s2.charAt(n - 1));
            n--;
        }
        return sb.reverse().toString();
    }
}

