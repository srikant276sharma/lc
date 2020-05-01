22. Generate Parentheses [M]
https://leetcode.com/problems/generate-parentheses/

/* Solution 1: Using Backtracking.
B2B: https://www.youtube.com/watch?v=sz1qaKt0KGQ 
     https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/GenerateNMatchedParenStrings/GenerateNMatchedParenStrings.java

3 Keys:
1. Our choice: Place a "(" or ")".
2. Our constraints: We can't close until we open. My count of left opens matters.
3. Our goal: n*2 placements.

Time complexity: ?.
Space complexity: O(n*2) => O(n), because of Call Stack, where n is the number of pairs of parentheses.
*/

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateBalancedParentheses(n, n, "", list);
        return list;
    }

    private void generateBalancedParentheses(int openParenCount, int closeParenCount, String inProgressParenStr, List<String> list) {
        if (openParenCount == 0 && closeParenCount == 0) {
            list.add(inProgressParenStr);
            return;
        }

        if (openParenCount > 0) {
            generateBalancedParentheses(openParenCount - 1, closeParenCount, inProgressParenStr + "(", list);
        }
        if (openParenCount < closeParenCount) {
            generateBalancedParentheses(openParenCount, closeParenCount - 1, inProgressParenStr + ")", list);
        }
    }
}


/*
  This repository is no longer actively maintained. To find all solutions to this problem (and practice coding more problems) at:
  ~~~~~~~~~~~~~~~~~~~~~~~~~
  https://backtobackswe.com
  ~~~~~~~~~~~~~~~~~~~~~~~~~
*/

class Solution {
    public List<String> generateParentheses(int numPairs) {
        List<String> result = new ArrayList<>();
        directedGenerateBalancedParentheses(numPairs, numPairs, "", result); // kick off the recursion
        return result;
    }

    private void directedGenerateBalancedParentheses(int numLeftParensNeeded, int numRightParensNeeded, String parenStringInProgress, List<String> result) {
    /*
      The recursion has bottomed out.
      We have used all left and right parens necessary within constraints up
      to this point. Therefore, the answer we add will be a valid paren string.

      We can add this answer and then backtrack so the previous call can exhaust
      more possibilities and express more answers...and then return to its caller,
      etc. etc.
      Yeah...this is what backtracking is all about.
    */
        if (numLeftParensNeeded == 0 && numRightParensNeeded == 0) {
            result.add(parenStringInProgress);
            return;
        }

    /*
      At each frame of the recursion we have 2 things we can do:
      1.) Insert a left parenthesis
      2.) Insert a right parenthesis
      These represent all of the possibilities of paths we can take from this
      respective call. The path that we can take all depends on the state coming
      into this call.
    */

    /*
      Can we insert a left parenthesis? Only if we have lefts remaining to insert
      at this point in the recursion
    */
        if (numLeftParensNeeded > 0) {
      /*
        numLeftParensNeeded - 1 ->       We are using a left paren
        numRightParensNeeded ->          We did not use a right paren
        parenStringInProgress + "(" ->   We append a left paren to the string in progress
        result ->                        Just pass the result list along for the next call to use
      */
            directedGenerateBalancedParentheses(numLeftParensNeeded - 1, numRightParensNeeded, parenStringInProgress + "(", result);
        }

    /*
      Can we insert a right parenthesis? Only if the number of left parens needed
      is less than then number of right parens needed.

      This means that there are open left parenthesis to close OTHERWISE WE CANNOT
      USE A RIGHT TO CLOSE ANYTHING. We would lose balance.
    */
        if (numLeftParensNeeded < numRightParensNeeded) {
      /*
        numLeftParensNeeded ->           We did not use a left paren
        numRightParensNeeded - 1 ->      We used a right paren
        parenStringInProgress + ")" ->   We append a right paren to the string in progress
        result ->                        Just pass the result list along for the next call to use
      */
            directedGenerateBalancedParentheses(numLeftParensNeeded, numRightParensNeeded - 1, parenStringInProgress + ")", result);
        }
    }
}
