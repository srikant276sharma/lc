package com.company.visa;

import java.util.Arrays;

/*
case 1:
Imagine that you are standing at the starting point of a straight street and are trying to reach the end of the street.
This street is represented by a number line starting at 0 and ending at finish (finish > 0).
There are electric scooters scattered along the street to help you get to the end.
Specifically, the scooters are represented by an array scooters, with scooters[i] representing the location of the ith scooter.
Each scooter can travel up to 10 points along the number line before its battery is fully discharged and it cannot go further.
For example, if a scooter is located at point 5, it can travel to points 5, 7, ..., up to point 15 (inclusive), but it cannot get to point 16 or further.
To get to the end point of the street, you must use the following algorithm:

1. From the current position, travel to the nearest scooter to the right on foot. If there are no more scooters available, travel to the end point on foot.
2. Get on this scooter and use all of its battery/resources to travel as far as you can toward the end point.
3. If you still haven't reached the end point, repeat this process from step 1.

Given that you must use the algorithm described above to travel from the starting point of the street 0 to the end point of the street finish,
your task is to return the total distance that you will travel on foot.

output:
5
4
0
case 2:
7
4
10
case 3: scooter travelled
20
19
0
 * */
public class ScooterTravel {
    public static void main(String[] args) {
        int finish = 27;
        int[] scooters = {3, 7, 10, 15};
        int result = solution(finish, scooters);
        System.out.println(result);

        finish = 23;
        scooters = new int[]{7, 4, 14};
        result = solution(finish, scooters);
        System.out.println(result);

        finish = 10;
        scooters = new int[]{};
        result = solution(finish, scooters);
        System.out.println(result);
    }

    public static int solution(int finish, int[] scooters) {
        Arrays.sort(scooters); // Sort the scooter positions in ascending order.
        int totalDistance = 0;
        int currentPosition = 0;
        int scooterDistance = 0;

        for (int i = 0; i < scooters.length; ) {
            // Find the nearest scooter to the right.
            int nearestScooter = -1;
            int minDistance = Integer.MAX_VALUE;

            while (i < scooters.length && scooters[i] - currentPosition <= 10) {
                int distance = scooters[i] - currentPosition;
                if (distance < minDistance) {
                    minDistance = distance;
                    nearestScooter = i;
                }
                i++;
            }
            if (nearestScooter == -1) {
                // If no scooter is within 10 points, walk to the finish.
                totalDistance += finish - currentPosition;
                break;
            } else {
                // Walk to the nearest scooter.
                totalDistance += scooters[nearestScooter] - currentPosition;
                currentPosition = scooters[nearestScooter];
                // If there is a scooter at position x, you can use it to go to x+10.
                currentPosition += 10;
            }
        }

//        totalDistance += Math.max((finish - currentPosition), 0);
//        scooterDistance = finish - totalDistance;
//        return scooterDistance;
        return totalDistance;
    }
}
