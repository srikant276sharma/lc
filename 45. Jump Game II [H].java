45. Jump Game II [H]
https://leetcode.com/problems/jump-game-ii/

/* Solution 1: Using Dynamic Programming.
Vivekanand: https://www.youtube.com/watch?v=jH_5ypQggWg
Tushar: https://www.youtube.com/watch?v=cETfFsSTGJI
        https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MinJumpToReachEnd.java

Time complexity: O(n^2).
Space complexity: O(n), to maintain minJump array.
*/

class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        int[] minJump = new int[len];
        //Min jump required to reach 1st element is 0.
        minJump[0] = 0;
        //we need to find Min value so initialize with Max value.
        for (int i = 1; i < len; i++) {
            minJump[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i < len; i++) {
            //For every i, j starts from 0.
            for (int j = 0; j < i; j++) {
                //Check whether current element i is reachable or not, and Set the MinJump.
                if ((j + nums[j] >= i) && (minJump[i] > minJump[j] + 1)) {
                    minJump[i] = minJump[j] + 1;
                }
            }
        }

        return minJump[len - 1];
    }
}


/* Solution 2: Greedy approach.
Errichto: https://www.youtube.com/watch?v=0RHXjBKY9EM

Time complexity: O(n).
Space complexity: O(1).
*/

class Solution {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return 0;
        }

        int jumpStart = 0, jumpEnd = 0, minJumps = 0, canReach = 0;
        while (true) {
            minJumps++;
            for (int i = jumpStart; i <= jumpEnd; i++) {
                canReach = Math.max(canReach, i + nums[i]);
            }
            if (canReach >= len - 1) {
                return minJumps;
            }

            //Check in next jump interval.
            jumpStart = jumpEnd + 1;
            jumpEnd = canReach;
        }

    }
}

--
Asked by:
--
