345. Reverse Vowels of a String
https://leetcode.com/problems/reverse-vowels-of-a-string/

/*
*/

/*Solution 1. 
*/

class Solution {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');

        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();

        while (i < j) {
            if (vowels.contains(arr[i]) && vowels.contains(arr[j])) {
                char tmp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = tmp;
            } else if (vowels.contains(arr[i]) && !vowels.contains(arr[j])) {
                j--;
            } else if (!vowels.contains(arr[i]) && vowels.contains(arr[j])) {
                i++;
            } else {
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}

--
Time complexity: O(n) where n is the no. of characters.
Space complexity: O(n) because we are creating a new char array of n elements.
--
Asked by: Amazon.
--
