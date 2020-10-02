389. Find the Difference [E]
https://leetcode.com/problems/find-the-difference/

/* Solution 1: Using XOR operation.
KC: https://www.youtube.com/watch?v=sRwElQ_TOr8

TC: O(N), where N is the total number of characters.
SC: O(1).
*/

class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
        
        for (char cs : s.toCharArray()) {
            c ^= cs;
        }
        for (char ct : t.toCharArray()) {
            c ^= ct;
        }
        return c;
    }
}
