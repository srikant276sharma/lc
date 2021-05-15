/*
1167. Minimum Cost to Connect Sticks
https://leetcode.com/problems/minimum-cost-to-connect-sticks/
*/

class Solution {
    public int connectSticks(int[] sticks) {
        int minCost = 0;
        //input check.
        if (sticks == null || sticks.length == 0) {
            return minCost;
        }
        //minHeap.
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        //add all sticks to minHeap.
        for (int stick : sticks) {
            minHeap.add(stick);
        }
        
        while (minHeap.size() > 1) {
            int cost = minHeap.poll() + minHeap.poll(); //adding 2 min sticks.
            minCost += cost;
            minHeap.add(cost);
        }
        return minCost;
    }
}
