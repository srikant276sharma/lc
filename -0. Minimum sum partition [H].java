Minimum sum partition [H]
https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1

/* Solution 1: Type: 0/1 Knapsack.
Tech Dose: https://www.youtube.com/watch?v=FB0KUhsxXGY&t=25s

TC: O(N * W), where N = number of elements in nums, W = sum.
SC: O(N * W)
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
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDiffernce(A,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution {
    public int minDiffernce(int arr[], int n) { 
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        
        //find all possible subset sum.
        boolean[][] dp = new boolean[n + 1][sum + 1]; //adding an extra row and column for 0.
        
        for (int i = 0; i <= n; i++) { //iterate over num.
            for (int j = 0; j <= sum; j++) { //iterate over sum.
                if (j == 0) {
                    dp[i][j] = true; //as we can have empty set, with sum == 0 so setting true.
                } else if (i == 0) {
                    dp[i][j] = false; //with num == 0, we can't make cur sum.
                } else if (arr[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j]; //num > cur sum: exclude.
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]]; //exclude or include num.
                }
            }
        }
        
        //find min differene.
        int diff = Integer.MAX_VALUE;
        //iterate from 0 to sum / 2 as s1 <= s2 so, s1 <= sum / 2.
        for (int i = 0; i <= sum / 2; i++) {
            int s1 = i;
            int s2 = sum - i;
            //check last dp row if subset sum is possible or not.
            if (dp[n][i] && diff > Math.abs(s1 - s2)) {
                diff = Math.abs(s1 - s2);
            }
        }
        return diff;
    } 
}
