969. Pancake Sorting [M]
https://leetcode.com/problems/pancake-sorting/

/* Solution 1:
KC: https://www.youtube.com/watch?v=AFtXLUn_TZg&t=6s

TC: O(n^2).
SC: O(n).
*/

class Solution {
    public List<Integer> pancakeSort(int[] A) {
        List<Integer> result = new ArrayList<>();
        int n = A.length;

        //back to forward processing so that after each iteration, we can reduce search space.
        for (int i = n - 1; i > 0; i--) {
            //1. Find max element.
            //starting from 1 to skip iteration if req num is already at begining.
            for (int j = 1; j <= i; j++) {
                if (A[j] == i + 1) { //checking with i + 1 because of 0 based index.
                    //2. bring max element to front.
                    flip(A, j);
                    result.add(j + 1); //adding 1 because of 0 based index.
                    break;
                }
            }
            //3. put max element at the end.
            flip(A, i);
            result.add(i + 1); //adding 1 because of 0 based index.
        }
        return result;
    }

    private void flip(int[] A, int idx) {
        for (int i = 0; i <= idx / 2; i++) {
            int temp = A[i];
            A[i] = A[idx - i];
            A[idx - i] = temp;
        }
    }
}
