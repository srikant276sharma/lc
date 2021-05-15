/*
Max Sum Subarray of size K.
https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
*/

//User function Template for Java
class Solution {
    static int maximumSumSubarray(int k, ArrayList<Integer> arr, int n){
        int i = 0, j = 0; //i denotes start of window and j denotes end of window.
        int maxSum = Integer.MIN_VALUE, sum = 0;
        
        while (j < n) { //process till end.
            sum += arr.get(j);

            if (j - i + 1 < k) { //when window size is < k.
                j++;
            } else if (j - i + 1 == k) { //when window size = k.
                //take action.
                maxSum = Math.max(maxSum, sum);
                sum -= arr.get(i);
                i++;
                j++;
            } 
        }
        return maxSum;
    }
}
