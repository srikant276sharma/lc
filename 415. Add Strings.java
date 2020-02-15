415. Add Strings
https://leetcode.com/problems/add-strings/

/*
IMP: DON'T FORGET TO SUBTRACT '0'. ASCII value of '0' is 48.
int x = '0' - '0'; => 0
int y = '1' - '0'; => 1

Algorithm: Considering both num1 and num2 represent positive integer so both are not empty.
1. start adding least significant digits and store the result in a char[] or StringBuilder.
2. if it has carry then handle that.
*/

/*Solution 1: Using char[] */

class Solution {
    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carry = 0;
        int[] res = new int[Math.max(num1.length(), num2.length())];
        int k = res.length - 1;

        while (i1 >= 0 || i2 >= 0) {
            int x = (i1 >= 0) ? num1.charAt(i1--) - '0' : 0;
            int y = (i2 >= 0) ? num2.charAt(i2--) - '0' : 0;
            int sum = x + y + carry;
            res[k--] = sum % 10;
            carry = sum / 10;
        }

        StringBuilder sb = new StringBuilder();
        if (carry == 1) {
            sb.append(1);
        }
        for (int re : res) {
            sb.append(re);
        }
        return sb.toString();
    }
}

/*Solution 2: Using StringBuilder */

class Solution {
    public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i1 >= 0 || i2 >= 0) {
            int sum = carry;
            if (i1 >= 0) {
                sum += num1.charAt(i1--) - '0';
            }
            if (i2 >= 0) {
                sum += num2.charAt(i2--) - '0';
            }
            sb.append(sum % 10);
            carry = sum / 10;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
--
Complexity Analysis
Time complexity : O(max⁡(m,n)). Assume that m and n represents the length of num1 and num2 respectively, the algorithm above iterates at most max⁡(m,n) times.
Space complexity : O(max⁡(m,n)). The length of the new string is at most max⁡(m,n)+1.
--
