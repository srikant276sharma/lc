735. Asteroid Collision [M]
https://leetcode.com/problems/asteroid-collision/
https://leetcode.com/problems/asteroid-collision/discuss/376501/Java-solution-stack-with-clean-explanation

/*Solution 1.
loop the array from left to right, keep valid element in the stack.
if the stack is empty, push element into stack.
There are four cases regrad with the peek of stack and current element.

    stack peek positive, current positive -> push into stack
    stack peek negative, current negative -> push into stack
    stack peek negative, current positive -> push into stack
    stack peek positive, current negative -> most tricky part

in case four, there are three small cases

    if |current| equal the peek        -> destory both, which mean we pop the peek and check next element.
    if |current| smaller than the peek -> destory current, we skip current and continue check next element
    if |current| greater than peek     -> destory peek, we pop the peek and still need to compare current with the peek. so we don't increase array index.

*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < asteroids.length) {
            if (stack.isEmpty() || stack.peek() < 0 || asteroids[i] > 0) {
                stack.push(asteroids[i]);
                i++;
            } else {
                if (-asteroids[i] == stack.peek()) {
                    stack.pop();
                    i++;
                } else if (-asteroids[i] > stack.peek()) {
                    stack.pop();
                } else {
                    i++;
                }
            }
        }

        int size = stack.size();
        int[] remaining = new int[size];
        for (int j = size - 1; j >= 0; j--) {
            remaining[j] = stack.pop();
        }

        return remaining;
    }
}

--
Time Complexity: O(N), where N is number of elements in asteroids.
Space Complexity: O(N) where N is number of elements in asteroids.
--
Asked by: Lyft, Amazon.
--
