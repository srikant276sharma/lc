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
        Main main = new Main();
        int[] nums = new int[]{1, 2, 3, 3};
        System.out.println(main.countSubsetsWithSumX(nums, 6));
    }
    //
    public int countSubsetsWithSumX(int[] nums, int x) {
        int n = nums.length;
        
        int[][] dp = new int[n + 1][x + 1]; //adding an extra row and column for 0.
        
        for (int i = 0; i <= n; i++) { //iterate over num.
            for (int j = 0; j <= x; j++) { //iterate over sum.
                if (j == 0) { //when cur sum == 0. we can always have an empty set with it's element's sum == 0 so setting 1.
                    dp[i][j] = 1; 
                } else if (i == 0) { //when item == 0 then we can't make any subset so setting 0.
                    dp[i][j] = 0;
                } else if (nums[i - 1] > j) { //num > cur sum: exclude
                    dp[i][j] = dp[i - 1][j];
                } else { //include or exclude num.
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][x];
    }
}
