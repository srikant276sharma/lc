Minimum Difference Element in a Sorted Array [E]

/* Solution 1: Type: Binary Search.

Aditya: https://www.youtube.com/watch?v=3RhGdmoF_ac&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=15

TC: O(log n).
SC: O(1).
*/

public class MyClass {
    public static void main(String args[]) {
        int[] nums = new int[]{1, 3, 8, 10, 15};
        int k = 12; //output: 10
        
        int res = minDiffElement(nums, k);
        System.out.println(res);
    }
    
    private static int minDiffElement(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (k == nums[mid]) { //if key is present in the array then key will be the answer.
                return k;
            } else if (nums[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        //if key is not present in the array, then either low or high element will be answer.
        return Math.abs(nums[low] - k) < Math.abs(nums[high] - k) ? nums[low] : nums[high];
    }
}
