Subset Sum Problem | DP-25 [M]

/* Solution 1: Type: 0/1 Knapsack.
Aditya: https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7

TC: O(N * W), where N = number of elements in nums, W = sum.
SC: O(N * W), required to make dp table.
*/

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{3, 34, 4, 12, 5, 2};
        System.out.println(main.subsetSum(nums, 9));
    }
    //Subset Sum Problem.
    //input: [3, 34, 4, 12, 5, 2], sum = 9, output: true. There is a subset (4, 5) with sum 9.
    //input: [3, 34, 4, 12, 5, 2], sum = 30, output: false. There is no subset that add up to 30.
    public boolean subsetSum(int[] nums, int sum) {
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1]; //adding an extra row and column for 0.
        
        for (int i = 0; i <= n; i++) { //iterate over num;
            for (int j = 0; j <= sum; j++) { //iterate over sum.
                if (j == 0) { //with empty set, sum will be 0, so setting true.
                    dp[i][j] = true;
                } else if (i == 0) { //when num = 0, we can't make any sum, so setting false.
                    dp[i][j] = false;
                } else if (nums[i - 1] > j) { //num > cur sum, exclude num.
                    dp[i][j] = dp[i - 1][j];
                } else { //exclude or include num.
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum];
    }
}
