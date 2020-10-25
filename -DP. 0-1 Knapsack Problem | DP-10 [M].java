0-1 Knapsack Problem | DP-10 [M]

/* Solution 1: Type: 0/1 Knapsack.
https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/?ref=leftbar-rightbar

Aditya: https://www.youtube.com/watch?v=ntCGbPMeqgg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=5

TC: O(N * W), where N = number of elements in weight[], W = capacity.
SC: O(N * W), required to make dp table.
*/

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] value = new int[]{60, 100, 120};
        int[] weight = new int[]{10, 20, 30};
        int w = 50;
        System.out.println(main.knapsack(value, weight, w));
    }
    //0-1 Knapsack Problem | DP-10.
    public int knapsack(int[] value, int[] weight, int w) {
        int n = weight.length;
        int[][] dp = new int[n + 1][w + 1];
        
        for (int i = 0; i <= n; i++) { //iterate over weight.
            for (int j = 0; j <= w; j++) { //iterate over capacity.
                if (i == 0 || j == 0) { //if there is no item or if capacity is 0, then value will be 0.
                    dp[i][j] = 0;
                } else if (weight[i - 1] > j) { //weight > capacity, so exclude cur weight.
                    dp[i][j] = dp[i - 1][j];
                } else { //include or exclude cur weight and while including add cur value.
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }
            }
        }
        return dp[n][w];
    }
}
