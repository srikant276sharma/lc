887. Super Egg Drop [H]
https://leetcode.com/problems/super-egg-drop/

/* Solution 1: Using Top-Down Dynamic Programming and Binary Search.
https://leetcode.com/problems/super-egg-drop/discuss/159055/Java-DP-solution-from-O(KN2)-to-O(KNlogN)

B2B: https://www.youtube.com/watch?v=iOaRjDT0vjc
     https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/EggDrop/TopDown.java
Tushar: https://www.youtube.com/watch?v=3hcaVyX00_4
        https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/EggDropping.java
Knowledge Center: https://www.youtube.com/watch?v=RUhT21pRMQQ&list=PL1w8k37X_6L-UQSn0c4DJJmbLb2DzDBkx             

Time complexity: O(KN logN).
Space complexity: O(KN).

Asked by:
*/

class Solution {
    public int superEggDrop(int K, int N) {
        int[][] minNoOfMoves = new int[K + 1][N + 1];

        //No of egg = 1 then considering the worst case, min no. of moves = no. of floors.
        for (int i = 1; i <= N; i++) {
            minNoOfMoves[1][i] = i;
        }
        //No of floor = 1 then it does matter how many eggs we have, min no. of moves = 1 (No. of floor).
        for (int j = 1; j <= K; j++) {
            minNoOfMoves[j][1] = 1;
        }

        for (int egg = 2; egg <= K; egg++) {
            for (int floor = 2; floor <= N; floor++) {
                //Using Binary Search to get the minimum 'Math.max(eggBreak, eggDidntBreak) + 1', when eggBreak and eggDidntBreak are as close as possible.
                int low = 1, high = floor, minTrails = floor;

                while (low <= high) {
                    int mid = low + (high - low) / 2;
                    int eggBreak = minNoOfMoves[egg - 1][mid - 1];
                    int eggDidntBreak = minNoOfMoves[egg][floor - mid];
                    minTrails = Math.min(minTrails, Math.max(eggBreak, eggDidntBreak));

                    if (eggBreak == eggDidntBreak) {
                        break;
                    } else if (eggBreak < eggDidntBreak) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                minNoOfMoves[egg][floor] = minTrails + 1; //set min worst moves.
            }
        }

        return minNoOfMoves[K][N];
    }
}
