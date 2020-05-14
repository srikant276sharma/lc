402. Remove K Digits [M]
https://leetcode.com/problems/remove-k-digits/

/* Solution 1: Using Stack.
https://leetcode.com/problems/remove-k-digits/discuss/88708/Straightforward-Java-Solution-Using-Stack

Time: O(n + k), where n = number of characters in input string and k = number of digits to be removed.
Space: O(n).

Asked by: .
*/

class Solution {
    public String removeKdigits(String num, int k) {
        int len = num.length();
        if (k == len) {
            return "0";
        }

        Stack<Character> stack = new Stack<>();
        String res = "";

        for (char c : num.toCharArray()) {
            //whenever meet a digit which is less than the previous digit, discard the previous digit.
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        //To handle a scenario like "1111" or "112".
        while (k > 0) {
            stack.pop();
            k--;
        }

        //Construct result from stack.
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        res = sb.reverse().toString();

        //if res has any leading 0's then remove leading 0's.
        if (res.charAt(0) == '0') {
            int i = 0;
            while (i < res.length() && res.charAt(i) == '0') {
                i++;
            }
            res = res.substring(i);
        }

        if (res.length() == 0) {
            return "0";
        }
        return res;
    }
}

/*Solution: 2
 Knowledge Center: https://www.youtube.com/watch?v=xk6aYK2IzVk
*/

class Solution {
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }

        int i = 0;
        while (k > 0) {
            i = (i > 0) ? (i - 1) : 0;

            while (i < num.length() - 1 && num.charAt(i) <= num.charAt(i + 1)) {
                i++;
            }
            num = num.substring(0, i) + num.substring(i + 1);
            k--;
        }

        if (num.charAt(0) == '0') {
            i = 0;
            while (i < num.length() && num.charAt(i) == '0') {
                i++;
            }
            num = num.substring(i);
        }

        if (num.length() == 0) {
            return "0";
        }
        return num;
    }
}
