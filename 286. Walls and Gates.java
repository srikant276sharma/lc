286. Walls and Gates
https://leetcode.com/problems/walls-and-gates/

/*
You are given a m x n 2D grid initialized with these three possible values.

-1  - A wall or an obstacle.
0   - A gate.
INF - Infinity means an empty room. We use the value 2^31 - 1 = 2147483647 to represent INF 
      as you may assume that the distance to a gate is less than 2147483647.

Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

For example, given the 2D grid:
INF -1  0   INF
INF INF INF -1
INF -1  INF -1
0   -1  INF INF

After running your function, the 2D grid should be:
3 -1 0 1
2 2  1 -1
1 -1 2 -1
0 -1 3 4

*/

/*Solution 1.
classic BFS: 
- Push all gates into queue first. 
  Then for each gate update its neighbor cells and push them to the queue.
- Repeating above steps until there is nothing left in the queue.

https://leetcode.com/problems/walls-and-gates/discuss/72748/Benchmarks-of-DFS-and-BFS
*/

class Solution {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        int rows = rooms.length;
        int cols = rooms[0].length;
        Queue<Integer> queue = new LinkedList<>();

        /* Add all gates to the queue. */
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    /* Add location of gate i, j: while retrieving use, cell / cols, cell % cols. */
                    queue.offer(i * cols + j);
                }
            }
        }
        /*Left, Up, Right, Down */
        int[] directions = new int[]{0, -1, 0, 1, 0};

        while (!queue.isEmpty()) {
            int cell = queue.poll();
            int cellR = cell / cols;
            int cellC = cell % cols;
            /*check all 4 directions around the gate. */
            for (int i = 0; i < 4; i++) {
                int nextR = cellR + directions[i];
                int nextC = cellC + directions[i + 1];

                if (nextR >= 0 || nextR < rows
                        || nextC >= 0 || nextC < cols
                        || rooms[nextR][nextC] == Integer.MAX_VALUE) {
                    /*increment the cell value by 1. */
                    rooms[nextR][nextC] = rooms[cellR][cellC] + 1;
                    /*add to the queue. */
                    queue.offer(nextR * cols + nextC);
                }
            }
        }
    }
}

--
Time complexity: O(m*n) where m is the number of rows and n is the number of columns.
Space complexity: O(m*n) for queue space.
--
Asked by: Facebook, Amazon, Microsoft and Uber.
--
