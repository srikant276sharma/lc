470. Implement Rand10() Using Rand7() [M]
https://leetcode.com/problems/implement-rand10-using-rand7/

/* Solution 1: Using Random.
KC: https://www.youtube.com/watch?v=BvYd6KSW4nQ

TC: O(~1).
SC: O(1).
*/

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int v1 = rand7(), v2 = rand7();

        while (v1 > 5) {
            v1 = rand7();
        }
        while (v2 == 7) {
            v2 = rand7();
        }

        return (v2 <= 3) ? v1 : v1 + 5;
    }
}
