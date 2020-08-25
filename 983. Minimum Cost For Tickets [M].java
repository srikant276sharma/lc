983. Minimum Cost For Tickets [M]
https://leetcode.com/problems/minimum-cost-for-tickets/

/* Solution 1: Using Bottom Up Dynamic Programming.
KC: https://www.youtube.com/watch?v=HyN5hdD1JU4

TC: O(n), where is the length of days array.
SC: O(n), to maintain DP array.
*/

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++) {
            dp[i] = 1001; //Max costs value + 1.
        }

        //Bottom Up approach.
        for (int i = n - 1; i >= 0; i--) {
            int d7 = i, d30 = i;
            
            while (d7 < n && days[d7] < days[i] + 7) {
                d7++;
            }
            while (d30 < n && days[d30] < days[i] + 30) {
                d30++;
            }
            dp[i] = Math.min(costs[0] + dp[i + 1], Math.min(costs[1] + dp[d7], costs[2] + dp[d30]));
        }

        return dp[0];
    }
}
