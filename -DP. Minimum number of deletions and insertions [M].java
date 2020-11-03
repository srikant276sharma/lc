Minimum number of deletions and insertions [M]

/* Solution 1: Type: LCS.
https://practice.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1#

Aditya: https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25

TC: O(R * C), where R = length of string 1, C = length of string 2.
SC: O(R * C), required to make dp table.
*/

// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s1 = sc.next();
                    String s2 = sc.next();
                    Solution ob = new Solution();
                    System.out.println(ob.minOperations(s1,s2));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution {
    public int minOperations(String str1, String str2) { 
        //find lcs.
        //number of deletions = length of str1 - length of lcs.
        //number of insertions = length of str2 - length of lcs.
        //min no. of deletions and insertions = number of deletions + number of insertions.
        
        //find lcs.
        int l1 = str1.length(), l2 = str2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        
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
        
        int noOfDeletions = l1 - dp[l1][l2];
        int noOfInsertions = l2 - dp[l1][l2];
        return noOfDeletions + noOfInsertions;
    } 
}
