402. Remove K Digits [M]
https://leetcode.com/problems/remove-k-digits/

/* Solution 1: Using Stack.
TD: https://www.youtube.com/watch?v=3QJzHqNAEXs
Time: O(n)
Space: O(n)
*/

class Solution {
    public String removeKdigits(String num, int k) {
        //input validation.
        if (num == null || num.length() == 0) {
            return "";
        }

        Stack<Character> st = new Stack<>();
        //store the final string in stack.
        for (char c : num.toCharArray()) {
            //in case of any dip, pop the peak elememt.
            while (k > 0 && !st.isEmpty() && st.peek() > c) {
                st.pop();
                k--;
            }
            //to handle leading 0 and input like [10200, 1 => 200]
            if (!st.isEmpty() || c != '0') {
                st.push(c);
            }
        }
        //for input like 123: remove the largest values from the top of the stack.
        while (!st.isEmpty() && k > 0) {
            st.pop();
            k--;
        }
        if (st.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        
        return sb.reverse().toString();
    }
}

//TC: O(n)
//SC: O(n)
