709. To Lower Case
https://leetcode.com/problems/to-lower-case/

/*Solution 1.
ASCII value of 'A' = 65
ASCII value of 'a' = 97.
There is a gap of 32.
*/
 
class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (Character c : str.toCharArray()) {
            if (c - 'A' >= 0 && c - 'A' < 26) {
                sb.append((char) (c + 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

--
Time complexity: O(n). There are total n characters and we visit each character once.
Space complexity: O(n).
--
Asked by: .
--
