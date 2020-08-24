1032. Stream of Characters [H]
https://leetcode.com/problems/stream-of-characters/

/* Solution 1: Using Reverse Trie and Deque.
KC: https://www.youtube.com/watch?v=Y37WA4advWw&t=1314s

TC: O(n), where n = stream size = total queried letters.
SC: O(c), where c = content size = total space to store all words in Trie.
*/

class StreamChecker {

    public Trie trie = new Trie();
    public Deque<Character> stream = new LinkedList<>();
    
    public StreamChecker(String[] words) {
        for (String word : words) {
            String wordRev = new StringBuilder(word).reverse().toString(); //reversing the word.
            trie.insert(wordRev);
        }
    }
    
    public boolean query(char letter) {
        //adding current letter at the begining so that stream can match with reversed word.
        stream.addFirst(letter); 
        return trie.search(stream);
    }
}

class Trie {
    private Map<Character, Trie> child;
    private boolean endOfWord;

    public Trie() {
        child = new HashMap<>();
        endOfWord = false;
    }

    //input words are cd, f, kl but in trie, we are inserting like dc, f, lk.
    public void insert(String word) {
        Trie curr = this;
        
        for (char c : word.toCharArray()) {
            Trie node = curr.child.get(c);
            if (node == null) {
                node = new Trie();
                curr.child.put(c, node);
            }
            curr = node;
        }
        curr.endOfWord = true;
    }

    public boolean search(Deque<Character> stream) {
        Trie curr = this;

        for (char c : stream) {
            Trie node = curr.child.get(c);
            if (node == null) {
                return false;
            }
            curr = node;
            if (curr.endOfWord == true) {
                return true;
            }
        }
        return false;
    } 
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
