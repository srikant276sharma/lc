412. Fizz Buzz [E]
https://leetcode.com/problems/fizz-buzz/

/* Solution 1:
Algorithm:
1. Initialize an empty answer list.
2. Iterate on the numbers from 1...N.
3. For every number, if it is divisible by both 3 and 5, add FizzBuzz to the answer list.
4. Else, Check if the number is divisible by 3, add Fizz.
5. Else, Check if the number is divisible by 5, add Buzz.
6. Else, add the number.

TC: O(n), where n is the input.
SC: O(n).
*/

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        if (n < 1) {
            return res;
        }

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}
