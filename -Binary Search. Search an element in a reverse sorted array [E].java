Search an element in a reverse sorted array [E]

/* Solution 1: Type: Binary Search.
https://www.geeksforgeeks.org/search-an-element-in-a-reverse-sorted-array/

Aditya: https://www.youtube.com/watch?v=YbkELwnGRdo&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=3

TC: O(log n).
SC: O(1).
*/

class GFG {
    public static void main (String[] args) {
        int[] nums = new int[]{5, 4, 3, 2, 1};
        System.out.println(binarySearch(nums, 4)); //output: 1
        nums = new int[]{10, 8, 2, -9};
        System.out.println(binarySearch(nums, 5)); //output: -1        
    }
    //Search an element in a reverse sorted array.
    private static int binarySearch(int[] nums, int x) {
        int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (x == nums[mid]) {
                return mid;
            } else if (x < nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
