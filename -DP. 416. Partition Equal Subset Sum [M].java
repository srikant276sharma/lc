416. Partition Equal Subset Sum [M]
https://leetcode.com/problems/partition-equal-subset-sum/

/* Solution 1: Type: 0/1 Knapsack.
Tech Dose: https://www.youtube.com/watch?v=obhWqDfzwQQ&t=39s

TC: O(N * W), where N = number of elements in nums, W = sum of all elements / 2 ~ sum value.
SC: O(N * W)
*/

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, n = nums.length;
        
        for (int num : nums) {
            sum += num;
        }
        //odd sum check, for partition equal subset sum, sum should be even.
        if (sum % 2 != 0) {
            return false;
        }
        //adding an extra row and column because of 0.
        boolean[][] dp = new boolean[n + 1][sum / 2 + 1];
        
        for (int i = 0; i <= n; i++) { //iterate over num.
            for (int j = 0; j <= sum / 2; j++) { //iterate over sum.
                //base case.
                if (j == 0) { //cur sum == 0.
                    dp[i][j]  = true;
                } else if (i == 0) { //num == 0.
                    dp[i][j] = false;
                } else if (nums[i - 1] > j) { //exclude: num > cur sum.
                    dp[i][j] = dp[i - 1][j];
                } else { //exclude or include num.
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][sum / 2];
    }
}
