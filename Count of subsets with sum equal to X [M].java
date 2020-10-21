Count of subsets with sum equal to X [M]
https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/

/* Solution 1: Type: 0/1 Knapsack.
Tech Dose: https://www.youtube.com/watch?v=MqYLmIzl8sQ&t=20s

TC: O(N * W), where N = number of elements in nums, W = sum.
SC: O(N * W)
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1};
        Main main = new Main();
        System.out.println(main.countSubsetsWithSum(nums, 1));
    }
    //
    public int countSubsetsWithSum(int[] nums, int sum) {
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1]; //because of 0, added an extra row and column.
        
        //when item == 0 then we can't make any subset so setting 0.
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = 0;
        }
        //when cur sum == 0. we can always have an empty set with it's element's sum == 0 so setting 1.
        for (int j = 0; j <= n; j++) {
            dp[j][0] = 1;
        }
        //Decision making.
        for (int i = 1; i <= n; i++) { //num iteration.
            for (int j = 1; j <= sum; j++) { //sum iteration.
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j]; //exclude cur num.
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]]; //exclude or include cur num.
                }
            }
        }
        return dp[n][sum];
    }
}
