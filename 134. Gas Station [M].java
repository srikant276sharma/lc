134. Gas Station [M]
https://leetcode.com/problems/gas-station/

/* Solution 1: Using Greedy approach.
KC: https://www.youtube.com/watch?v=xmJZSYSvgfE

TC: O(N), where N is length of input array.
SC: O(1).
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalSurplus = 0, surplus = 0, startIdx = 0, n = gas.length;
        
        for (int i = 0; i < n; i++) {
            totalSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if (surplus < 0) {
                //starting index was not valid, move to next index.
                surplus = 0;
                startIdx = i + 1;
            }
        }
        return (totalSurplus < 0) ? -1 : startIdx;
    }
}
