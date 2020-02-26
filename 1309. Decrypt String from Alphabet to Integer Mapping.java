1309. Decrypt String from Alphabet to Integer Mapping
https://leetcode.com/problems/decrypt-string-from-alphabet-to-integer-mapping/

/*Solution 1.
ASCII value of small letter starts from 97.
In this problem, 'a' is represented by '1' so adding 96 to integer value of '1' to get the ASCII value of 'a'.
*/
 
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder res = new StringBuilder();
        int num;
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                num = Integer.parseInt(s.substring(i, i + 2));
                res.append((char) (num + 96));
                i = i + 2;
            } else {
                num = Integer.parseInt(s.substring(i, i + 1));
                res.append((char) (num + 96));
            }
        }
        return res.toString();
    }
}

--
Time complexity: O(n). There are total n characters and we visit each character once.
Space complexity: O(n).
--
Asked by: .
--
