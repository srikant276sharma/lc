208. Implement Trie (Prefix Tree) [M]
https://leetcode.com/problems/implement-trie-prefix-tree/

/* Solution 1:.
Tushar: https://www.youtube.com/watch?v=AXjmTQ8LEoI
        https://github.com/mission-peace/interview/blob/master/src/com/interview/suffixprefix/Trie.java

Time:  Insert                     | Search | StartsWith
       O(N * L) > O(1 * L) > O(L) | O(L)   | O(L)
Space: O(L)                       | O(1)   | O(1)
       where N = number of words, L = average length of words.

Asked by:
*/

class Trie {

    private class TrieNode {
        Map<Character, TrieNode> child;
        boolean endOfWord;

        public TrieNode() {
            child = new HashMap<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie: Iterative implementation.
     */
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.child.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.child.put(ch, node);
            }
            current = node;
        }
        //Mark the current nodes endOfWord as true.
        current.endOfWord = true;
    }

    /**
     * Returns if the word is in the trie: Iterative implementation of search into trie.
     */
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode node = current.child.get(ch);
            //If node does not exist for given char then return false.
            if (node == null) {
                return false;
            }
            //return true, if current's endOfWord is true, else return false.
            current = node;
        }

        return current.endOfWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            TrieNode node = current.child.get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }

        return true;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
