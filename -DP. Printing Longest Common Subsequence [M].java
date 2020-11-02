Printing Longest Common Subsequence [M]

/* Solution 1: Type: LCS.
https://www.geeksforgeeks.org/printing-longest-common-subsequence/

Aditya: https://www.youtube.com/watch?v=x5hQvnUcjiM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23

TC: O(R * C), where R = length of string 1, C = length of string 2.
SC: O(R * C), required to make dp table.
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        System.out.println(main.printLcs("abcdgh", "aedfhr")); //output: "adh"
        System.out.println(main.printLcs("aggtab", "gxtxayb")); //output: "gtab"
    }
    
    private static String printLcs(String str1, String str2) {
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
        //print lcs.
        int m = l1, n = l2;
        StringBuilder sb = new StringBuilder();
        
        while (m > 0 && n > 0) {
            //when chars match, move top left diagonally.
            if (str1.charAt(m - 1) == str2.charAt(n - 1)) { //because of 0 based index, -1.
                sb.append(str1.charAt(m - 1));
                m--; //move up.
                n--; //move left.
            } else { //when chars didn't match, move towards max value cell.
                if (dp[m][n - 1] > dp[m - 1][n]) {
                    n--; //move left.
                } else {
                    m--; //move up.
                }
            }
        }
        return sb.reverse().toString();
    }
}
