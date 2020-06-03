1029. Two City Scheduling [E]
https://leetcode.com/problems/two-city-scheduling/

/* Solution 1: Using Greedy approach. 

Algorithm:
- Sort the persons in the ascending order by price_A - price_B parameter, which indicates the company additional costs.
- To minimise the costs, send n persons with the smallest price_A - price_B to the city A, and the others to the city B.

TC: O(n log n), where n is number of rows in input matrix or number of persons.
SC: O(1).

Asked by:
*/

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> (a[0] - a[1]) - (b[0] - b[1]));
        int minCost = 0, len = costs.length;

        for (int i = 0; i < len / 2; i++) {
            minCost += costs[i][0]; //sending to city A.
        }
        for (int i = len / 2; i < len; i++) {
            minCost += costs[i][1]; //sending to city B.
        }

        return minCost;
    }
}
