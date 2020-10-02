127. Word Ladder [M]
https://leetcode.com/problems/word-ladder/

/* Solution 1: Using BFS.
Amell: https://www.youtube.com/watch?v=PeyYhb8lJJU

TC: O(W*L*26*W) ~ O(W^2 * L), where W is number of words, L is length of word.
SC: O(W).
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //SC: O(W).
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        
        //SC: O(W).
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int result = 0;
        
        while (!queue.isEmpty()) {
            //level processing. TC: O(W).
            for (int levelSize = queue.size(); levelSize > 0; levelSize--) {
                String word = queue.poll();
                if (endWord.equals(word)) {
                    return result + 1;    
                }
                //processing word by replacing each character at a time. TC: O(L).
                for (int chIdx = 0; chIdx < word.length(); chIdx++) {
                    char[] wordArr = word.toCharArray();
                    //TC: O(26).
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArr[chIdx] = c;
                        String transWord = new String(wordArr);
                        //checking for transformed word. TC: O(W).
                        if (wordSet.contains(transWord) && !transWord.equals(word)) {
                            queue.add(transWord);
                            //remove the transformed word so that the word can be used only once.
                            wordSet.remove(transWord); 
                        }
                    }
                }
            }
            //after level processing increment the counter.
            result++;
        }
        
        return 0;
    }
}
