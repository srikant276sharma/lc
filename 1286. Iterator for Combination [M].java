1286. Iterator for Combination [M]
https://leetcode.com/problems/iterator-for-combination/

/* Solution 1: Using Backtracking and Queue.
KC: https://www.youtube.com/watch?v=LzYlG_p1-zs

TC: O(). Need to check.
SC: O(n), where n is the size of queue.
*/

class CombinationIterator {
    private String s;
    private Queue<String> queue;

    private void getCombination(int start, int length, StringBuilder txt) {
        if (length == 0) {
            queue.add(txt.toString());
            return;
        }
        for (int i = start; i <= s.length() - length; i++) {
            txt.append(s.charAt(i));
            getCombination(i + 1, length - 1, txt); //process next character and reduce length by 1.
            txt.deleteCharAt(txt.length() - 1);
        }
    }

    public CombinationIterator(String characters, int combinationLength) {
        s = characters;
        queue = new LinkedList<>();
        getCombination(0, combinationLength, new StringBuilder());
    }

    public String next() {
        return queue.poll();
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
