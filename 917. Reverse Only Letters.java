917. Reverse Only Letters
https://leetcode.com/problems/reverse-only-letters/

/*Solution 1.
*/
 
class Solution {
    public String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length() - 1;
        char[] arr = S.toCharArray();

        while (i < j) {
            if (Character.isLetter(arr[i]) && Character.isLetter(arr[j])) {
                char tmp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = tmp;
            } else if (!Character.isLetter(arr[i]) && Character.isLetter(arr[j])) {
                i++;
            } else if (Character.isLetter(arr[i]) && !Character.isLetter(arr[j])) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}

--
Time complexity: O(n) where n is no. of characters in the String.
Space complexity: O(n).
--
Asked by: Microsoft.
--
