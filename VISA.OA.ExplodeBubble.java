package com.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

 * */
public class TestClass {
    private static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int row, col;

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {3, 1, 2, 1},
                {1, 1, 1, 4},
                {3, 1, 2, 2},
                {3, 3, 3, 4}
        };
        int[][] out = burstBubble(input);
        System.out.println(Arrays.deepToString(out));
    }

    private static int[][] burstBubble(int[][] input) {
        //validate input.
        if (input == null || input.length == 0) {
            return input;
        }
        row = input.length;
        col = input[0].length;
        int[][] res = new int[row][col];
        List<int[]> explode = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                dfs(input, explode, i, j);
            }
        }
        //explode.
        for (int[] e : explode) {
            input[e[0]][e[1]] = 0;
        }
        //
        for (int j = 0; j < col; j++) {
            int cur = row - 1;
            for (int i = row - 1; i >= 0; i--) {
                if (input[i][j] > 0) {
                    res[cur][j] = input[i][j];
                    cur--;
                }
            }
        }
        return res;
    }

    private static void dfs(int[][] input, List<int[]> explode, int i, int j) {
        //base case.
        if (i < 0 || i >= input.length || j < 0 || j >= input[0].length) {
            return;
        }
        int bubbleColor = input[i][j];
        List<int[]> adj = new ArrayList<>();

        for (int[] d : dir) {
            int x = d[0] + i;
            int y = d[1] + j;
            if (x >= 0 && x < row && y >= 0 && y < col && input[x][y] == bubbleColor) {
                adj.add(new int[]{x, y});
            }
        }
        if (adj.size() >= 2) {
            explode.add(new int[]{i, j});
            explode.addAll(adj);
        }
    }

}

//output: [[0, 0, 0, 1], [0, 0, 0, 4], [0, 0, 2, 2], [3, 0, 2, 4]]

