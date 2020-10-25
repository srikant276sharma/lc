Count the number of subset with a given difference [M]

/* Solution 1: Type: 0/1 Knapsack.
Aditya: https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11
Tech Dose: https://www.youtube.com/watch?v=QihB4bI6BJw

TC: O(N * W), where N = number of elements in nums, W = (diff + sum) / 2.
SC: O(N * W)
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] nums = new int[]{1, 1, 2, 3};
        System.out.println(main.numOfSubsetsWithGivenDiff(nums, 1));
    }
    //Count the number of subset with a given difference.
    //input: [1,1,2,3], diff = 1.
    //[1+3|1+2], [1+3|1+2], [1+1+2|3]. output: 3.
    public int numOfSubsetsWithGivenDiff(int[] nums, int diff) {
        //s1 - s2 = diff and s1 + s2 = sum. adding these 2 conditions result in
        //s1 = (diff + sum) / 2 = a constant value.
        //so it's similar to, Count of subsets with sum equal to X.
        int sum = 0, n = nums.length;
        //calculate total sum.
        for (int num : nums) {
            sum += num;
        }
        int target = (diff + sum) / 2; //new target value.
        int[][] dp = new int[n + 1][target + 1]; //adding an extra row and column for 0.
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0) { //with empty set we can have sum = 0, so setting 1.
                    dp[i][j] = 1;
                } else if (i == 0) { //with num = 0, we can't make any sum.
                    dp[i][j] = 0;
                } else if (nums[i - 1] > j) { //num > cur sum: exclude num.
                    dp[i][j] = dp[i - 1][j];
                } else { //exclude or include num.
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }
}
