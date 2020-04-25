146. LRU Cache [M]
https://leetcode.com/problems/lru-cache/

/* Solution 1:
Using LinkedHashMap.
Knowledge Center: https://www.youtube.com/watch?v=iEmActx7dYc&t=1563s
*/

class LRUCache {
    int cacheCapacity;
    LinkedHashMap<Integer, Integer> map;

    public LRUCache(int capacity) {
        cacheCapacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            map.remove(key);    //Remove the key.
            map.put(key, val);  //Add it to the front.
            return val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);    //Remove the key.
        } else if (map.size() == cacheCapacity) {
            map.remove(map.keySet().iterator().next()); //Remove the least recently used element.
        }
        map.put(key, value);    //Add it to the front.
    }
}


/* Solution 2:
Using HashMap and Doubly Linked List.
B2B: https://www.youtube.com/watch?v=S6IfqDXWa10
     https://github.com/bephrem1/backtobackswe/blob/master/Linked%20Lists/LRUCache/LRUCache.java
*/

class LRUCache {

    int cacheCapacity;
    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;

    public LRUCache(int capacity) {
        cacheCapacity = capacity;
        map = new HashMap<>(cacheCapacity);

        head = new ListNode();
        tail = new ListNode();

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            removeFromList(node);
            addToFront(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.val = value;

            removeFromList(node);
            addToFront(node);
        } else {
            if (map.size() == cacheCapacity) {
                ListNode lruNode = removeLRUEntry();
                map.remove(lruNode.key);
            }
            ListNode node = new ListNode();
            node.key = key;
            node.val = value;

            map.put(key, node);
            addToFront(node);
        }
    }

    //Helper functions.
    /* prevNode > "node" < nextNode */
    private void removeFromList(ListNode node) {
        ListNode prevNode = node.prev;
        ListNode nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    /* "lruNode" < tail */
    private ListNode removeLRUEntry() {
        ListNode lruNode = tail.prev;
        removeFromList(lruNode);
        return lruNode;
    }

    /* head > "node" < head.next */
    private void addToFront(ListNode node) {
        head.next.prev = node;
        node.next = head.next;

        node.prev = head;
        head.next = node;
    }

    private class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

--
Complexities:
Time: O(1).
Space: O(n), where n is equal to capacity.
--
Asked by: Microsoft, Adobe, Citigroup, Amazon.
--
