Search in an almost sorted array [E]

/* Solution 1: Type: Binary Search.
https://www.geeksforgeeks.org/search-almost-sorted-array/

Aditya: https://www.youtube.com/watch?v=W3-KgsCVH1U&list=PL_z_8CaSLPWeYfhtuKHj-9MpYb6XQJ_f2&index=9

TC: O(log n).
SC: O(1).
*/

class Solution {
  public static void main(String[] args) {
    //int index = almostSortedArray(new int[]{10, 3, 40, 20, 50, 80, 70}, 40); //output: 2
    int index = almostSortedArray(new int[]{10, 3, 40, 20, 50, 80, 70}, 90); //output: -1
    System.out.println(index);    
  }
  
  private static int almostSortedArray(int[] nums, int x) {
    int n = nums.length;
    int start = 0, end = n - 1;
    
    while (start <= end) {
      int mid = start + (end - start) / 2;
      
      if (nums[mid] == x) {
        return mid;
      } else if (mid - 1 >= start && nums[mid - 1] == x) {
        return mid - 1;
      } else if (mid + 1 <= end && nums[mid + 1] == x) {
        return mid + 1;
      } else if (x < nums[mid]) {
        end = mid - 2;
      } else {
        start = mid + 2;
      }
    }
    
    return -1;
  }
}
