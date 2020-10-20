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
        //odd sum check.
        if (sum % 2 != 0) {
            return false; 
        }
        
        boolean[][] dp = new boolean[n + 1][sum / 2 + 1]; //because of 0, adding an extra row and column.
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (i == 0 || j == 0) { //base case.
                    dp[i][j] = false;
                } else if (nums[i - 1] > j) { //exclude case: cur num > cur sum.
                    dp[i][j] = dp[i - 1][j];
                } else if (nums[i - 1] == j) { //cur num == cur sum.
                    dp[i][j] = true;
                } else { //exclude cur num or include cur num.
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        
        return dp[n][sum / 2];
    }
}
