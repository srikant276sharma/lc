1103. Distribute Candies to People [E]
https://leetcode.com/problems/distribute-candies-to-people/

/* Solution 1:
KC: https://www.youtube.com/watch?v=bNllLSJgApM&t=4s

TC: O(SqRoot C), where C is a Constant.
SC: O(N), where N is equal to num_people.
*/

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int candiesCount = 1, idx = 0;

        while (candies > 0) {
            res[idx++] += candiesCount;
            if (idx == num_people) {
                idx = 0;
            }
            candies -= candiesCount;
            candiesCount++;
            if (candiesCount > candies) {
                candiesCount = candies;
            }
        }
        return res;
    }
}
