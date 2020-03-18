1108. Defanging an IP Address [E]
https://leetcode.com/problems/defanging-an-ip-address/

/*Solution 1.
Using StringBuilder.
*/

class Solution {
    public String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();
        for (Character c : address.toCharArray()) {
            if (c == '.') {
                res.append("[.]");
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}

--
Time Complexity: O(N), where N is number of characters in the input String.
Space Complexity: O(N), where N is number of characters in the input String.
--
Asked by: Apple, Facebook, Adobe.
--
