151. Reverse Words in a String [M]
https://leetcode.com/problems/reverse-words-in-a-string/

/*Solution 1: Using 2 pointers and StringBuilder.

TC: O(n), where n is the no. of characters in the input String.
SC: O(n).
*/

class Solution {
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        int i = 0, len = s.length();

        while (i < len) {
            while (i < len && s.charAt(i) == ' ') {
                i++;
            }
            if (i == len) {
                break;
            }

            int j = i + 1;
            while (j < len && s.charAt(j) != ' ') {
                j++;
            }

            String word = s.substring(i, j);
            if (result.length() == 0) {
                result.append(word);
            } else {
                result.insert(0, word + " "); //Remember.
            }

            i = j + 1;
        }

        return result.toString();
    }
}
