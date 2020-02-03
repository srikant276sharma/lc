412. Fizz Buzz
https://leetcode.com/problems/fizz-buzz/

--Solution 1:
Algorithm:
1. Initialize an empty answer list.
2. Iterate on the numbers from 1...N.
3. For every number, if it is divisible by both 3 and 5, add FizzBuzz to the answer list.
4. Else, Check if the number is divisible by 3, add Fizz.
5. Else, Check if the number is divisible by 5, add Buzz.
6. Else, add the number.

--
class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> fbList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                fbList.add("FizzBuzz");
            } else if (i % 5 == 0) {
                fbList.add("Buzz");
            } else if (i % 3 == 0) {
                fbList.add("Fizz");
            } else {
                fbList.add(Integer.toString(i));
            }
        }
        return fbList;
    }
}
--
Time Complexity: O(N)
Space Complexity: O(1)
--
