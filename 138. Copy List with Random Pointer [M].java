138. Copy List with Random Pointer [M]
https://leetcode.com/problems/copy-list-with-random-pointer/

/* Solution 1: Using HashMap.
B2B: https://github.com/bephrem1/backtobackswe/blob/master/Linked%20Lists/CloneLinkedListWithRandomPointers/LinearSpace.java

TC: O(n).
SC: O(n).
*/

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }
    
    //map holds Node and its clone Node.
    Map<Node, Node> cloneMap = new HashMap<>();
    Node cur = head;
    
    while (cur != null) {
      cloneMap.put(cur, new Node(cur.val));
      cur = cur.next;
    }
    
    cur = head;
    while (cur != null) {
      //Set the next of cur's clone to > The clone of cur's next.
      cloneMap.get(cur).next = cloneMap.get(cur.next);
      //Set the random of cur's clone to > The clone of cur's random.
      cloneMap.get(cur).random = cloneMap.get(cur.random);
      cur = cur.next;
    }
    //return the head of clone list.
    return cloneMap.get(head);
  }
}
