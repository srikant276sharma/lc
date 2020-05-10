131. Palindrome Partitioning [M]
https://leetcode.com/problems/palindrome-partitioning/

/* Solution 1: Using Backtracking.
B2B: https://www.youtube.com/watch?v=4ykBXGbonlA
     https://github.com/bephrem1/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/PalindromePartitioning/PalindromePartitioning.java

Time: O(n * (2^n))
      Worst case, but much better than approach 1 since this is a rare worst case where all partitions turn out to be palindromic (a string of all 1 character).
      Our best case becomes greatly improved.
      We are basically taking subsets so (2^n) and the O(n) time to copy array to our answer.

Space: O(n)
       At worst we will always go n stack frames deep in our recursion since an all single character decomposition is always a palindromic decomposition. This does not include the output array in space.

       But let us imagine that we do include the output space. We will have (2 ^ (n-1)) decompositions of the string.
       We will certainly not have (2^n) PALINDROMIC decompositions for the string in a normal case.
       The length of each decomposition will very likely not be n in the normal case (n/2 is probably a better approximation but I'm honestly not sure).

       So approximate length for each decomposition: (n/2). MAXIMUM decompositions we could ever make: (2 ^ (n-1)).
       So this yields a VERY loose upper bound on the space with the output array included: O( (n/2) * (2 ^ (n-1)) ) = O( n * 2^n)
       REMEMBER THAT n IS THE # OF CHARACTERS IN THE STRING PASSED IN TO US.

Asked by:
*/

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> inProgressPartition = new ArrayList<>();
        generatePartitions(s, 0, inProgressPartition, partitions);
        return partitions;
    }

    private void generatePartitions(String s, int workingIndex, List<String> inProgressPartition, List<List<String>> partitions) {
        //If we have partitioned the whole string then reap the 'inProgressPartition', it's now complete.
        if (workingIndex == s.length()) {
            partitions.add(new ArrayList<>(inProgressPartition));
            return;
        }

        //Try every substring from 'workingIndex' to the end of string. It's our possibility space that we can recurse into.
        for (int i = workingIndex; i < s.length(); i++) {
            //only recurse if the substring from 'workingIndex' to 'i' (both inclusive) is a palindrome.
            if (isPalindrome(workingIndex, i, s)) {
                //1. Choose: Take the substring & add it to our partition 'path'.
                String palindromicSubstring = s.substring(workingIndex, i + 1);
                inProgressPartition.add(palindromicSubstring);
                //2. Explore: Recurse and try after 'palindromicSubstring'.
                generatePartitions(s, i + 1, inProgressPartition, partitions);
                //3. Unchoose: We are done searching, remove the substring from our 'path'. Next iteration will try another substring in this stack frame.
                inProgressPartition.remove(inProgressPartition.size() - 1);
            }
        }
    }

    //Check if the partition from left to right (both inclusive) is a palindrome.
    private boolean isPalindrome(int left, int right, String s) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
