88. Merge Sorted Array
https://leetcode.com/problems/merge-sorted-array/

--Solution 1:

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0, k = 0;
        int[] tmp = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                tmp[k] = nums1[i];
                i++;
            } else {
                tmp[k] = nums2[j];
                j++;
            }
            k++;
        }
        //
        while (i < m) {
            tmp[k] = nums1[i];
            i++;
            k++;
        }
        //
        while (j < n) {
            tmp[k] = nums2[j];
            j++;
            k++;
        }
        System.arraycopy(tmp, 0, nums1, 0, m + n);
    }
}
--
Time complexity: O(n).
Space complexity: O(n).

--Solution 2:

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int count = m + n - 1;
        m--;
        n--;

        //Start by setting greater element at the end of the first array nums1.
        while (m >= 0 && n >= 0) {
            if (nums1[m] > nums2[n])
                nums1[count--] = nums1[m--];
            else
                nums1[count--] = nums2[n--];
        }
        //In case nums2 still has some element.
        while (n >= 0) {
            nums1[count--] = nums2[n--];
        }
    }
}

--
Time complexity: O(n).
Space complexity: O(1).
--
Runtime: 0 ms, faster than 100.00% of Java online submissions for Merge Sorted Array.
Memory Usage: 38.6 MB, less than 5.94% of Java online submissions for Merge Sorted Array.
--
