Find position of an element in a sorted array of infinite numbers [E]

/* Solution 1: Type: Binary Search.
https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

Aditya: https://www.youtube.com/watch?v=FzvK5uuaki8&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=13

TC: O(log n).
SC: O(1).
*/

public class MyClass {
    public static void main(String args[]) {
        int[] nums = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int x = 10;
        //call helper method.
        int index = binarySearch(nums, x);
        System.out.println(index);
    }
    
    private static int binarySearch(int[] nums, int x) {
        int low = 0, high = 1;
        
        while (x > nums[high]) {
            low = high;
            high *= 2;
        }
        //apply normal binary search.
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (x == nums[mid]) {
                return mid;
            } else if (nums[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
