967. Numbers With Same Consecutive Differences [M]
https://leetcode.com/problems/numbers-with-same-consecutive-differences/

/* Solution 1:
KC: https://www.youtube.com/watch?v=TAfXh2l9FyA&t=12s

TC: O(N*2^N), where N is no. of Digits.
SC: O(N*2^N).
*/

class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> result = new ArrayList<>();
        if (N == 1) {
            result.add(0);
        }

        for (int d = 1; d <= 9; d++) {
            dfs(d, N - 1, K, result);
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int num, int N, int K, List<Integer> result) {
        if (N == 0) {
            result.add(num);
            return;
        }
        int lastDigit = num % 10;
        if (lastDigit >= K) {
            dfs(num * 10 + lastDigit - K, N - 1, K, result);
        }
        if (K > 0 && lastDigit + K < 10) {
            dfs(num * 10 + lastDigit + K, N - 1, K, result);
        }
    }
}
