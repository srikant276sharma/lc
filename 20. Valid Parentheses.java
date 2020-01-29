20. Valid Parentheses
https://leetcode.com/problems/valid-parentheses/

--Solution 1:

class Solution {
    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
--
Runtime: 1 ms, faster than 98.61% of Java online submissions for Valid Parentheses.
Memory Usage: 37.9 MB, less than 5.06% of Java online submissions for Valid Parentheses.
--
Time complexity: O(n).
Space complexity: O(n).
--
