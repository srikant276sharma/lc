67. Add Binary [E]
https://leetcode.com/problems/add-binary/

/*Solution 1: Using String.
KC: https://www.youtube.com/watch?v=SwPXgTiv8Ag

TC: O(Max(m, n)), where m = length of String a and n = length of String b.
SC: O(Max(m, n)).
*/

class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1, carry = 0;
        StringBuilder res = new StringBuilder();

        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }
            carry = (sum > 1) ? 1 : 0;
            res.append(sum % 2);
        }

        if (carry == 1) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
