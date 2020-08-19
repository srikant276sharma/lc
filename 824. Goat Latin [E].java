824. Goat Latin [E]
https://leetcode.com/problems/goat-latin/

/* Solution 1:
TC: O(n)+O(k^2), where n = length of input string, w = average length of each word, number of words available is roughly k = n/w.
SC: O(n)+O(k^2).

In the worst case, each word is only a single character long. 
Thus k=n. the overall complexity becomes ∼O(n)+O(n^2) ≃ O(n^2).
*/

class Solution {
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder(), suffix = new StringBuilder();
        Character[] vowelsArr = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        Set<Character> vowels = new HashSet<>(Arrays.asList(vowelsArr));

        for (String word : S.split(" ")) {
            suffix.append("a");
            if (vowels.contains(word.charAt(0))) {
                sb.append(word);
            } else {
                sb.append(word.substring(1)).append(word.charAt(0));
            }
            sb.append("ma").append(suffix).append(" ");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }
}
