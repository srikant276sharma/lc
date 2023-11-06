package com.company.visa;

import java.util.Arrays;

/*

 * */
public class BuildingDensity {

    public static void main(String[] args) {
        int[] houses = new int[]{1, 2, 3, 6, 7, 9};
        int[] queries = new int[]{6, 3, 7, 2, 9, 1};
        System.out.println(Arrays.toString(buildingDensity(houses, queries)));

        houses = new int[]{2, 4, 5, 6, 7};
        queries = new int[]{5, 6, 2};
        System.out.println(Arrays.toString(buildingDensity(houses, queries)));
    }

    public static int[] buildingDensity(int[] houses, int[] queries) {
        //validate input.
        if (houses == null || houses.length == 0 || queries == null || queries.length == 0) {
            return houses;
        }
        int hl = houses.length, ql = queries.length;
        int[] res = new int[ql];

        for (int i = 0; i < ql; i++) {
            int noOfSeg = helper(houses, queries[i]);
            res[i] = noOfSeg;
        }
        return res;
    }

    private static int helper(int[] houses, int query) {
        //Arrays.sort(houses);
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == query) {
                houses[i] = 0;
            }
        }
        houses = Arrays.stream(houses).filter(x -> x != 0).toArray();

        if (houses.length == 1) {
            return 1;
        }
        //calculate partition.
        int partition = 0;

        for (int i = 0; i < houses.length - 1; i++) {
            if (houses[i] + 1 == houses[i + 1]) {
                continue;
            } else {
                partition++;
            }
        }
        return (partition > 0) ? partition + 1 : 0;
    }

}
