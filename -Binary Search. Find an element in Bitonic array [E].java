Find an element in Bitonic array [E]

/* Solution 1: Type: Binary Search.

Aditya: https://www.youtube.com/watch?v=IjaP8qt1IYI&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=19

TC: O(log n).
SC: O(1).
*/

//Find an element in Bitonic array.

public class MyClass {
    public static void main(String args[]) {
        //test case 1:
        //int[] nums = new int[]{-3, 9, 18, 20, 17, 5, 1};
        //int key = 20; //output: 3
        
        //test case 2:
        int[] nums = new int[]{5, 6, 7, 8, 9, 10, 3, 2, 1};
        int key = 30; //output: -1
        
        int res = searchBitonicArray(nums, key);
        System.out.println(res);
    }
    
    //1. find max element index in bitonic array.
    //2. search in ascending array between 0 and index - 1
    //3. search in descending array between index and size - 1.
    private static int searchBitonicArray(int[] nums, int key) {
        int n = nums.length;
        int maxElementIdx = findMaxElementIdx(nums);
        
        int res = ascBinarySearch(nums, 0, maxElementIdx - 1, key); //ascending array.
        if (res == -1) {
            res = descBinarySearch(nums, maxElementIdx, n - 1, key); //descending array.
        }
        return res;
    }
    
    private static int findMaxElementIdx(int[] nums) {
        int n = nums.length, low = 0, high = n - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (mid > 0 && mid < n - 1) {
                if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                    return mid;
                } else if (nums[mid - 1] > nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (mid == 0) {
                return nums[0] > nums[1] ? 0 : 1;
            } else if (mid == n - 1) {
                return nums[n - 1] > nums[n - 2] ? n - 1 : n - 2;
            }
        }
        return -1;
    }
    
    //search in ascending array.
    private static int ascBinarySearch(int[] nums, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    
    //search in descending array.
    private static int descBinarySearch(int[] nums, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (nums[mid] == key) {
                return mid;
            } else if (nums[mid] < key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }    
    
}
