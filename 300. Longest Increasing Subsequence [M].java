300. Longest Increasing Subsequence [M]
https://leetcode.com/problems/longest-increasing-subsequence/

/* Solution 1: Using Dynamic Programming.
B2B: https://www.youtube.com/watch?v=fV-TF4OvZpk
     https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/LongestIncreasingSubsequence/LongestIncreasingSubsequence.java
     
Time complexity: O(n^2)
Space complexity: O(n).
*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        //Each index records the answer to "what is the longest increasing subsequence ending at index i of the original array?"
        int[] longest = new int[nums.length];
        Arrays.fill(longest, 1);
        int longestSoFar = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    //Hold the current length or extend the length.
                    longest[i] = Math.max(longest[i], longest[j] + 1);
                }
            }
            //We now have an answer for LIS[0...i]. Compete it against the best LIS length found so far.
            longestSoFar = Math.max(longestSoFar, longest[i]);
        }

        return longestSoFar;
    }
}


//B2B>>
/*
  This repository is no longer actively maintained. To find all solutions
  to this problem (and practice coding more problems) at:
  ~~~~~~~~~~~~~~~~~~~~~~~~~
  https://backtobackswe.com
  ~~~~~~~~~~~~~~~~~~~~~~~~~
*/

class Solution {
  public int lengthOfLIS(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    /*
      Array to store our subproblems, default answer is 1. A single
      item is neither increasing or decreasing, kind of a middle ground.
      Each index records the answer to "what is the longest increasing
      subsequence ending at index i of the original array?"
    */
    int[] maxLength = new int[nums.length];
    Arrays.fill(maxLength , 1);

    // By default the best answer is a length of 1
    int maximumSoFar = 1;
    
    /*
      Test every possible end index of a longest increasing subsequence
    */
    for (int i = 1; i < nums.length; i++) {

      /*
        We aim to see if we can append the item at nums[i]
        to extend the Longest Increasing Subsequence achieved
        from index 0...j (which is what the cache records)
        We want to solve for maxLength[i] if the value at 'i'
        beats 'j'. If we can we see which is greater between
        these then we have our answer:
        1.) maxLength[i]: The best answer so far for the LIS from 0...i
        2.) maxLength[j] + 1: The value of maxLength[j] is the length
        of the LIS from 0...j, we conceptually "append" this item to
        that LIS by adding 1 to that subproblem answer, yielding a
        potentially new answer for LIS[0..i]
      */
      for (int j = 0; j < i; j++){
        if (nums[i] > nums[j]) {
          maxLength[i] = Math.max(maxLength[i], maxLength[j] + 1);
        }
      }

      /*
        We now have an answer for LIS[0...i]. Compete it against the
        best LIS length found so far.
      */
      maximumSoFar = Math.max(maximumSoFar, maxLength[i]);
    }

    return maximumSoFar;
  }
}
