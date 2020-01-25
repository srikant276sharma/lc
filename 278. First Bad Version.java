278. First Bad Version
https://leetcode.com/problems/first-bad-version/

Algorithm:
There is just 1 place in the array where the versions go from "good" to "bad". 
We can use a modified version of binary search to find this location.
--
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
--
Implementation Details:
Instead of calculating the middle value as mid = (lo + hi) / 2, do mid = lo + (hi - lo) / 2 to avoid integer overflow.
--
Time Complexity: O(log n)
Space Complexity: O(1)
--
Facebook: 15
Google: 2
--
