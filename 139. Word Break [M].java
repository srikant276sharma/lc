139. Word Break [M]
https://leetcode.com/problems/word-break/

/* Solution 1: Using Dynamic Programming.
Tushar: https://www.youtube.com/watch?v=WepWFGxiwRs

Algorithm:
The intuition behind this approach is that the given problem (s) can be divided into subproblems s1 and s2. 
If these subproblems individually satisfy the required conditions, the complete problem, s also satisfies the same. 
e.g. "catsanddog" can be split into two substrings "catsand", "dog". 
The subproblem "catsand" can be further divided into "cats","and", which individually are a part of the dictionary 
making "catsand" satisfy the condition. 

Going further backwards, "catsand", "dog" also satisfy the required criteria individually leading to the complete string "catsanddog" also to satisfy the criteria.

Now, we'll move onto the process of dp array formation. 
We make use of dp array of size n+1, where n is the length of the given string. 
We also use two index pointers i and j, 
where i refers to the length of the substring (s′) considered currently starting from the beginning, 
and j refers to the index partitioning the current substring (s′) into smaller substrings s′(0,j) and s′(j+1,i). 

To fill in the dp array, we initialize the element dp[0] as true, since the null string is always present in the dictionary, 
and the rest of the elements of dp as false. 
We consider substrings of all possible lengths starting from the beginning by making use of index i. 
For every such substring, we partition the string into two further substrings s1′ and s2′ in all possible ways using the index j 
(Note that the i now refers to the ending index of s2′). 

Now, to fill in the entry dp[i], we check if the dp[j] contains true, i.e. if the substring s1′ fulfills the required criteria. 
If so, we further check if s2′ is present in the dictionary. If both the strings fulfill the criteria, we make dp[i] as true, otherwise as false.


TC: O(N^2).
SC: O(N).
*/

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }
}
