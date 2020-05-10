997. Find the Town Judge [E]
https://leetcode.com/problems/find-the-town-judge/

/* Solution 1: Using Array indexing.
Nick: https://www.youtube.com/watch?v=2AdzmA1IC1k

Time complexity: O(n), where n is number of pairs in the input array 'trust'.
Space complexity: O(N), where N is number of people in the town.

Asked by:
*/

class Solution {
    public int findJudge(int N, int[][] trust) {
        int[] trustCount = new int[N + 1];

        for (int[] t : trust) {
            trustCount[t[0]]--; //the person trusting someone else.
            trustCount[t[1]]++; //the person being trusted.
        }

        for (int i = 1; i <= N; i++) {
            if (trustCount[i] == N - 1) { //N - 1 : everybody (except for the judge) trusts the judge.
                return i;
            }
        }
        return -1;
    }
}
