359. Logger Rate Limiter [E]
https://leetcode.com/problems/logger-rate-limiter/

/* Solution 1: Using Hash Map.

TC: O(1).
SC: O(n).

Asked by: Google, Amazon.
*/

class Logger {

    HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.containsKey(message)) {
            if (timestamp - map.get(message) >= 10) {
                map.put(message, timestamp);
                return true;
            }
        } else {
            map.put(message, timestamp);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
