1422. Maximum Score After Splitting a String [E]
https://leetcode.com/problems/maximum-score-after-splitting-a-string/

/* Solution 1: Iterative.
*/

class Solution {
    public int maxScore(String s) {
        String rightSub = "";
        int zeroCount = 0;
        int oneCount = 0;
        int score = 0;

        //s.length() - 1, because we need to split the string into 2 non-empty substrings.
        for (int i = 0; i < s.length() - 1; i++) {
            //Count zeroes.
            if (s.charAt(i) == '0') {
                zeroCount++;
            }

            //Count one.
            rightSub = s.substring(i + 1);
            oneCount = 0;
            for (int j = 0; j < rightSub.length(); j++) {
                if (rightSub.charAt(j) == '1') {
                    oneCount++;
                }
            }
            //Keep the max score.
            score = Math.max(score, zeroCount + oneCount);
        }

        return score;
    }
}

--
Complexities:
Time: O(n^2).
Space: O(n), to store rightSub, where n is the number is characters in the input string.
--
Asked by:
--
