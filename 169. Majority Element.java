169. Majority Element [E]
https://leetcode.com/problems/majority-element/

/*Solution 1.

Algorithm: Boyer-Moore Vote Algorithm

Step1: Find a candidate for majority element:
1: Initialize count of current candidate as 0, count = 0
2: Iterate over the array and do following steps:
   (a) If count == 0, set candidate = array[i], count = 1
   (b) Else   
       (i) If candidate == array[i], set count = count + 1
       (ii) else set count = count - 1

Step 2: Check if candidate is Majority Element:
1: If count == 0, there is no majority element.
2: Else, iterate over array to get count of candidate.
    (a) If count is greater than n/2, return candidate.
    (b) Else return null. 
*/

class Solution {
    public int majorityElement(int[] nums) {
        /*Boyer-Moore Vote algorithm. */
        /*Step 1: Find a candidate for majority element. */
        int candidate = 0, count = 0;

        for (int i : nums) {
            if (count == 0) {
                candidate = i;
                count++;
            } else {
                if (candidate == i) {
                    count++;
                } else {
                    count--;
                }
            }
        }

        /*Step 2: Check if the candidate is a majority element. */
        if (count > 0) {
            count = 0;
            for (int i : nums) {
                if (candidate == i) {
                    count++;
                }
                if (count > nums.length / 2) {
                    return candidate;
                }
            }
        }
        return -1;
    }
}

--
Time complexity: O(n) where n is the no. of elements in the array.
Space complexity: O(1). Boyer-Moore allocates only constant additional memory.
--
Asked by: Google, Baidu.
--
