42. Trapping Rain Water [H]

/* Solution 1: Using 2 pointers.
https://leetcode.com/problems/trapping-rain-water/

Amell: https://www.youtube.com/watch?v=ZanjlzDaFoI

TC: O(N), where N is length of input array.
SC: O(1).
*/

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int res = 0, maxLowerLevel = 0, l = 0, r = height.length - 1;

        while (l < r) {
            int curLower = height[height[l] < height[r] ? l++ : r--];
            maxLowerLevel = Math.max(maxLowerLevel, curLower);
            res += maxLowerLevel - curLower;
        }
        return res;
    }
}

//Trapping Rain Water [H/M]

/* Solution 2: Type: Arrays.
https://practice.geeksforgeeks.org/problems/trapping-rain-water/0#

Aditya: https://www.youtube.com/watch?v=FbGG2qpNp4U&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=9

TC: O(n).
SC: O(n).
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        //BufferedReader is much faster than Scanner.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] s = br.readLine().split(" ");

            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(s[j]);
            }
            //call helper method.
            trapRainWater1(arr, n);
        }
        br.close();
    }

    //Solution 1: Execution Time:0.75
    private static void trapRainWater1(int[] arr, int n) {
        int[] maxL = new int[n]; //holds left side max elements.
        int[] maxR = new int[n]; //holds right side max elements.

        //make maxL: traverse from left to right.
        maxL[0] = arr[0];
        for (int i = 1; i < n; i++) {
            maxL[i] = Math.max(maxL[i - 1], arr[i]);
        }
        //make maxR: traverse from right to left.
        maxR[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxR[i] = Math.max(arr[i], maxR[i + 1]);
        }

        int trappedWater = 0;
        //calculate trapped water.
        for (int i = 0; i < n; i++) {
            trappedWater += Math.min(maxL[i], maxR[i]) - arr[i]; //container height - building height.
        }
        //return water;
        System.out.println(trappedWater);
    }

    //Solution 2: Execution Time:0.57
    private static void trapRainWater2(int[] arr, int n) {
        int i = 0, j = n - 1;
        int trappedWater = 0, containerHeight = 0;

        while (i < j) {
            int buildingHeight = arr[i] < arr[j] ? arr[i++] : arr[j--];
            containerHeight = Math.max(containerHeight, buildingHeight);
            trappedWater += containerHeight - buildingHeight;
        }
        System.out.println(trappedWater);
    }
}
