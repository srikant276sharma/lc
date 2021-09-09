394. Decode String [M]
https://leetcode.com/problems/decode-string/

/*
Assume, n is the length of the string s.
Time Complexity: O(maxK⋅n)
Space Complexity: O(n). This is the space used to store the internal call stack used for recursion. 
As we are recursively decoding each nested pattern, the maximum depth of recursive call stack would not be more than n.
*/

class Solution {
    int index = 0;
    String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index)))
                result.append(s.charAt(index++));
            else {
                int k = 0;
                // build k while next character is a digit
                while (index < s.length() && Character.isDigit(s.charAt(index)))
                    k = k * 10 + s.charAt(index++) - '0';
                // ignore the opening bracket '['    
                index++;
                String decodedString = decodeString(s);
                // ignore the closing bracket ']'
                index++;
                // build k[decodedString] and append to the result
                while (k-- > 0)
                    result.append(decodedString);
            }
        }
        return new String(result);
    }
}
