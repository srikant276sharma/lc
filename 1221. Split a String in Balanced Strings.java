1221. Split a String in Balanced Strings
https://leetcode.com/problems/split-a-string-in-balanced-strings/

/*Solution 1.
*/
 
class Solution {
    public int balancedStringSplit(String s) {
        int balancedCount = 0;
        int balance = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == 'L') {
                balance++;
            } else if (current == 'R') {
                balance--;
            }
            
            if (balance == 0) {
                balancedCount++;
            }
        }
        return balancedCount;
    }
}

--
Time complexity: O(n) where n is no. of characters in the String.
Space complexity: O(1).
--
Asked by: Apple.
--
