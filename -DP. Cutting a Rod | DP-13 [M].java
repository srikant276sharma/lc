Cutting a Rod | DP-13 [M]

/* Solution 1: Type: Unbounded 01 Knapsack.
https://www.geeksforgeeks.org/cutting-a-rod-dp-13/

Aditya: https://www.youtube.com/watch?v=SZqAQLjDsag&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=14

TC: O(N * W), where N = length of peice array, W = length of rod.
SC: O(N * W), required to make dp table.
*/

// "static void main" must be defined in a public class.
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        //int[] price = new int[]{1, 5, 8, 9, 10, 17, 17, 20}; //output: 22
        int[] price = new int[]{3, 5, 8, 9, 10, 17, 17, 20}; //output: 24
        int rodLen = 8;
        System.out.println(main.cuttingRod(price, rodLen));
    }
    //Cutting a Rod | DP-13.
    //Type: Unbounded knapsack.
    public int cuttingRod(int[] price, int rodLen) {
        //create and fill peice length array.
        int[] length = new int[rodLen];
        for (int i = 0; i < rodLen; i++) { //in this case, we have sequential peice length.
            length[i] = i + 1; //fill from 1 till rodLen.
        }
        //adding an extra row and column for 0.
        int[][] dp = new int[rodLen + 1][rodLen + 1];
        
        for (int i = 0; i <= rodLen; i++) { //iterate over peice length.
            for (int j = 0; j <= rodLen; j++) { //iterate over rod length or capacity.
                if (i == 0 || j == 0) { //if peice length array is empty or if rod length is 0 then setting 0.
                    dp[i][j] = 0;
                } else if (length[i - 1] > j) { //peice length > cur rod length, exclude.
                    dp[i][j] = dp[i - 1][j];
                } else { //exclude or include peice length.
                    dp[i][j] = Math.max(dp[i - 1][j], price[i - 1] + dp[i][j - length[i - 1]]);
                }
            }
        }
        return dp[rodLen][rodLen];
    }
}
