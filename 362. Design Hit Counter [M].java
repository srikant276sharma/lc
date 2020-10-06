362. Design Hit Counter [M]
https://leetcode.com/problems/design-hit-counter/

/* Solution 1: Using Queue.

TC: O(300) ~ O(1).
SC: O(300) ~ O(1).
*/

class HitCounter {
    Queue<Integer> queue;
    /** Initialize your data structure here. */
    public HitCounter() {
        queue = new LinkedList<>();
    }
    
    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.add(timestamp);
        if (timestamp > 300) {
            removeExtra(timestamp);
        }
    }
    
    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        if (timestamp > 300) {
            removeExtra(timestamp);
        }        
        return queue.size();
    }
    
    public void removeExtra(int timestamp) {
        while (!queue.isEmpty() && queue.peek() <= timestamp - 300) {
            queue.poll();
        }  
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
