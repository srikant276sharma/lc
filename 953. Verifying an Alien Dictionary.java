953. Verifying an Alien Dictionary
https://leetcode.com/problems/verifying-an-alien-dictionary/

/*Solution 1.
Example 1:
Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
Output: true
Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
*/

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        String word1;
        String word2;
        int len;

        search:
        for (int i = 0; i < words.length - 1; i++) {
            word1 = words[i];
            word2 = words[i + 1];

            /*Loop only shorter word length times. */
            len = Math.min(word1.length(), word2.length());

            for (int j = 0; j < len; j++) {
                /*Check only first different character. */
                if (word1.charAt(j) != word2.charAt(j)) {
                    if (order.indexOf(word1.charAt(j)) > order.indexOf(word2.charAt(j))) {
                        return false;
                    } else {
                        continue search;
                    }
                }
            }

            /*If we didn't find any character difference then words are like "app", "apple". */
            if (word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
}

--
Time complexity: O(C) where C is total content of words, i.e. N * M, where N is len(words), M is average length of each word.
Space complexity: O(1).
--
Asked by: Facebook.
--
