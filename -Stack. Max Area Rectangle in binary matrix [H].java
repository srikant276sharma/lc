Max Area Rectangle in binary matrix [H]
85. Maximal Rectangle

/* Solution 1: Type: Stack.
https://leetcode.com/problems/maximal-rectangle/

Aditya: https://www.youtube.com/watch?v=St0Jf_VmG_g&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=8

TC: O().
SC: O().
*/

package com.marc.dsa;

import java.util.*;
import java.lang.*;

public class GFG {
    public static void main(String[] args) {
        char[][] matrix = new char[][]{{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        //char[][] matrix = new char[][]{{'0', '1'}, {'1', '0'}};
        System.out.println(maximalRectangle(matrix)); //output:
    }

    //Max area rectangle in a binary matrix.
    //Goal: Find the largest rectangle containing only 1's and return its area.
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int[] cur = new int[cols];
        int area = 0, maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //converting 2D matrix into 1D.
                if (matrix[i][j] == '0') {
                    cur[j] = 0;
                } else {
                    cur[j] += matrix[i][j] - '0';
                }
            }
            //process cur row.
            area = getMaxArea(cur, cols);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    //Maximum rectangular area in a histogram.
    private static int getMaxArea(int[] hist, int n) {
        Stack<int[]> stack = new Stack<>();

        //1. calculate Nearest Smaller to Right indices.
        int[] right = new int[n];
        int pseudoIndex = n;

        for (int i = n - 1; i >= 0; i--) { //traverse from right to left.
            if (stack.isEmpty()) {
                right[i] = pseudoIndex;
            } else if (stack.peek()[0] < hist[i]) {
                right[i] = stack.peek()[1];
            } else {
                while (stack.size() > 0 && stack.peek()[0] >= hist[i]) {
                    stack.pop();
                }
                right[i] = stack.isEmpty() ? pseudoIndex : stack.peek()[1];
            }
            //push element and its index.
            stack.push(new int[]{hist[i], i});
        }
        //2. calculate Nearest Smaller to Left indices.
        int[] left = new int[n];
        pseudoIndex = -1;
        stack = new Stack<>();

        for (int i = 0; i < n; i++) { //traverse left to right.
            if (stack.isEmpty()) {
                left[i] = pseudoIndex;
            } else if (stack.peek()[0] < hist[i]) {
                left[i] = stack.peek()[1];
            } else {
                while (stack.size() > 0 && stack.peek()[0] >= hist[i]) {
                    stack.pop();
                }
                left[i] = stack.isEmpty() ? pseudoIndex : stack.peek()[1];
            }
            //push element and its index.
            stack.push(new int[]{hist[i], i});
        }
        //3. calculate width.
        int[] width = new int[n];

        for (int i = 0; i < n; i++) {
            width[i] = right[i] - left[i] - 1;
        }
        //4. calculate area.
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, hist[i] * width[i]);
        }
        return maxArea;
    }
}
