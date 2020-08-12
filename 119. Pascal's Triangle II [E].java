119. Pascal's Triangle II [E]
https://leetcode.com/problems/pascals-triangle-ii/

/* Solution 1:
KC: https://www.youtube.com/watch?v=IWXZAvBIuyE&t=4s

TC: O(n^2), where n is input rowIndex.
SC: O(n).
*/

class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        //initialize with 1's.
        for (int i = 0; i <= rowIndex; i++) { 
            result.add(1); //size is 1 more.
        }

        //logic for rowIndex >= 2.
        for (int i = 1; i < rowIndex; i++) {
            //back to front processing.
            for (int j = i; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }

        return result;
    }
}
