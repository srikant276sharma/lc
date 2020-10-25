494. Target Sum [M]

/* Solution 1: Type: 0/1 Knapsack.
Aditya: https://www.youtube.com/watch?v=Hw6Ygp3JBYw&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=12
Tech Dose: https://www.youtube.com/watch?v=hqGa65Rp5LQ

TC: O(N * W), where N = number of elements in nums, W = target.
SC: O(N * W)
*/

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        //after assigning + and -, the array can be divided into 2 subsets.
        //one as +ve subsets s1 and the other as -ve subsets s2 and sum(s1) - sum(s2) should be S.
        //sum(s1) - sum(s2) = S and sum(s1) + sum(s2) = sum(nums), can be simplified to, sum(s1) = (S + sum(nums)) / 2.
        //Goal changed to >> Count the number of subset with a given difference >> Count of subsets with sum equal to X.
        int n = nums.length, arrSum = 0;
        //calculate input array sum.
        for (int num : nums) {
            arrSum += num;
        }
        //validate input.
        if (arrSum < S || (arrSum + S) % 2 != 0) {
            return 0;
        }
        
        int target = (S + arrSum) / 2;
        int[][] dp = new int[n + 1][target + 1]; //adding an extra row and column for 0.
        
        for (int i = 0; i <= n; i++) { //iterate over num.
            for (int j = 0; j <= target; j++) { //iterate over sum.
                if (j == 0) { //with empty set, we can have sum = 0, so setting 1.
                    dp[i][j] = 1;
                } else if (i == 0) { //with num = 0, we can't make any sum, so setting 0.
                    dp[i][j] = 0;
                } else if (nums[i - 1] > j) { //num > cur sum, exclude num.
                    dp[i][j] = dp[i - 1][j];
                } else { //exclude or include num.
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }
}
