705. Design HashSet [E]
https://leetcode.com/problems/design-hashset/

/* Solution 1:

TC: O(N/K) where N is the number of all possible values and K is the number of predefined buckets, which is 15000.
    Assuming that the values are evenly distributed, thus we could consider that the average size of bucket is N/K​.
    Since for each operation, in the worst case, we would need to scan the entire bucket, hence the time complexity is O(N/K).

SC: O(K+M) where K is the number of predefined buckets, and M is the number of unique values that have been inserted into the HashSet. 

Asked by: Google, Amazon.
*/

public class MyHashSet {
    private int bucketSize;
    ArrayList<Integer>[] bucket;

    private int hashFunc(int key) {
        return key % bucketSize;
    }

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        bucketSize = 15000;
        bucket = new ArrayList[bucketSize];
    }

    public void add(int key) {
        int hashKey = hashFunc(key);

        if (bucket[hashKey] == null) {
            bucket[hashKey] = new ArrayList<>();
        }
        if (!bucket[hashKey].contains(key)) {
            bucket[hashKey].add(key);
        }
    }

    public void remove(int key) {
        int hashKey = hashFunc(key);

        if (bucket[hashKey] == null) {
            return;
        }
        if (bucket[hashKey].contains(key)) {
            int idx = bucket[hashKey].indexOf(key);
            bucket[hashKey].remove(idx);
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int hashKey = hashFunc(key);
        if (bucket[hashKey] == null || !bucket[hashKey].contains(key)) {
            return false;
        }
        return true;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
