933. Number of Recent Calls [E]
https://leetcode.com/problems/number-of-recent-calls/

/* Solution 1: Using Queue.
Rachit: https://www.youtube.com/watch?v=or6zCRq3tFo

TC: O(n) where n can be max 3000.
SC: O(n).
*/

class RecentCounter {
    Queue<Integer> queue;
    
    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        queue.add(t);
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
