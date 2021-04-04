32. Longest Valid Parentheses [H].java

/*
Solution 1: Using Stack.

TC: O(n).
SC: O(n).
*/

class Solution {
    public int longestValidParentheses(String s) {
        //input check.
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int maxL = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); //adding starting index.
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i); //adding index of open parentheses.
            } else {
                stack.pop(); //in case of close parentheses pop out.
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxL = Math.max(maxL, i - stack.peek());
                }
            }
        }
        return maxL;
    }
}
