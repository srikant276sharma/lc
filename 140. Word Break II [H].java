140. Word Break II [H]
https://leetcode.com/problems/word-break-ii/

/*Solution 1: Using Dynamic Programming and Backtracking.
KC: https://www.youtube.com/watch?v=9-grHHGUVls

TC: O().
SC: O().
*/

class Solution {
    HashMap<String, List<String>> dp = new HashMap<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        if (dp.containsKey(s)) {
            return dp.get(s);
        }
        List<String> result = new ArrayList<>();

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (s.length() == word.length()) {
                    result.add(word);
                } else {
                    List<String> tmp = wordBreak(s.substring(word.length()), wordDict);
                    for (String t : tmp) {
                        result.add(word + " " + t);
                    }
                }
            }
        }
        dp.put(s, result);
        return result;
    }
}
