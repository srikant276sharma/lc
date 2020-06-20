60. Permutation Sequence [M]
https://leetcode.com/problems/permutation-sequence/

/* Solution 1: Using Backtracking, Map.
Similar: Tushar: https://www.youtube.com/watch?v=nYFd7VHKyWQ&t=1s

TC: O(N!), where N is the length of input array.
SC: O(N).

Asked by:
*/

class Solution {
    int count = 0, K = 0;

    public String getPermutation(int n, int k) {
        K = k;
        int[] nums = new int[n];
        int[] counts = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            counts[i] = 1;
        }

        List<Integer> temp = new ArrayList<>(Collections.nCopies(n, 0));
        permuteUtil(nums, counts, 0, temp);

        StringBuilder sb = new StringBuilder();
        for (int i : temp) {
            sb.append(i);
        }
        return sb.toString();
    }

    private void permuteUtil(int[] nums, int[] counts, int level, List<Integer> temp) {
        if (temp.size() == level) {
            count++;
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (counts[i] == 0) {
                continue;
            }
            temp.set(level, nums[i]);
            counts[i]--;
            permuteUtil(nums, counts, level + 1, temp);
            if (count == K) {
                return;
            }
            counts[i]++;
        }
    }
}
