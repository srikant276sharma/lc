957. Prison Cells After N Days [M]
https://leetcode.com/problems/prison-cells-after-n-days/

/* Solution 1: Using Hash Map.
KC: https://www.youtube.com/watch?v=XaayRYdKG0I

TC: O(L * C), where L is days cycle length and C is cells length - 2.
SC: O(L).
*/

class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> cellsState = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String curState = Arrays.toString(cells);
            if (cellsState.containsKey(curState)) {
                int cycleLen = i - cellsState.get(curState);
                int remainingDays = (N - i) % cycleLen;
                return prisonAfterNDays(cells, remainingDays);
            } else {
                cellsState.put(curState, i);
                int prev = cells[0];

                for (int j = 1; j < 7; j++) {
                    int cur = cells[j], next = cells[j + 1];
                    cells[j] = 1 - (prev ^ next);
                    prev = cur;
                }
            }

            cells[0] = cells[7] = 0;
        }

        return cells;
    }
}
