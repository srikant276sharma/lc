46. Permutations [M]
https://leetcode.com/problems/permutations/

/* Solution 1: Using Backtracking, Map.
Tushar: https://www.youtube.com/watch?v=nYFd7VHKyWQ&t=1s

TC: O(N!), where N is the length of input array.
SC: O(N * N!).

Asked by:
*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        int[] numbers = new int[countMap.size()];
        int[] counts = new int[countMap.size()];
        int index = 0;

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            numbers[index] = entry.getKey();
            counts[index] = entry.getValue();
            index++;
        }

        List<List<Integer>> resultList = new ArrayList<>();
        List<Integer> result = new ArrayList<>(Collections.nCopies(nums.length, 0)); //Remember: initialize list with 0's.
        permuteUtil(numbers, counts, result, 0, resultList);

        return resultList;
    }

    private void permuteUtil(int[] numbers, int[] counts, List<Integer> result, int level, List<List<Integer>> resultList) {
        if (level == result.size()) {
            resultList.add(new ArrayList<>(result)); //Remember: Create new list.
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (counts[i] == 0)
                continue;

            result.set(level, numbers[i]); //Remember: Set at current level.
            counts[i]--;
            permuteUtil(numbers, counts, result, level + 1, resultList);
            counts[i]++;
        }
    }
}
