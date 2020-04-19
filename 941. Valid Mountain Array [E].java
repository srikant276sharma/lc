941. Valid Mountain Array [E]
https://leetcode.com/problems/valid-mountain-array/

/* Solution 1:
Two pointer approach.
*/

class Solution {
    public boolean validMountainArray(int[] A) {
        int length = A.length;
        if (length < 3)
            return false;

        int i = 0;
        
        //Walk Up.
        while (i + 1 < length && A[i] < A[i + 1]) {
            i++;
        }
        
        //Peak can't be first or last element.
        if (i == 0 || i == length - 1) {
            return false;
        }
        
        //Walk Down.
        while (i + 1 < length && A[i] > A[i + 1]) {
            i++;
        }

        return i == length - 1;
    }
}

--
Complexities: Considering n is number of elements in the array.
Time: O(n).
Space: O(1).
--
Asked by: Google.
--
