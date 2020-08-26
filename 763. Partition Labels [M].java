763. Partition Labels [M]
https://leetcode.com/problems/partition-labels/

/* Solution 1:
Amell: https://www.youtube.com/watch?v=ig4ahJEj5ZM

TC: O(n), where n is input String length.
SC: O(26) ~ O(1), if we consider 26 as constant.
*/

class Solution {
    public List<Integer> partitionLabels(String S) {
        //lastPos holds the last index of each character.
        int[] lastPos = new int[26];
        int n = S.length();

        for (int i = 0; i < n; i++) {
            lastPos[S.charAt(i) - 'a'] = i;
        }

        //start holds partition start index, end holds partition end index.
        int start = 0, end = 0;
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            end = Math.max(end, lastPos[S.charAt(i) - 'a']);
            //at the end index of partition, split it.
            if (i == end) {
                result.add(end - start + 1); //including end index as well so adding 1.
                start = i + 1;
            }
        }
        return result;
    }
}
