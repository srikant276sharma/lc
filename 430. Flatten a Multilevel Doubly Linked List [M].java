430. Flatten a Multilevel Doubly Linked List [M]
https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

/* Solution 1: Using DFS. 
KC: https://www.youtube.com/watch?v=RIyPgR7AF7M&t=1332s

TC: O(n), where n is the number of nodes in the Linked List. As we are visiting each node of the Linked List once.
SC: O(n), because of recursive call stack.
*/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if (head != null) {
            flattenRec(head);
        }
        return head;
    }

    private Node flattenRec(Node head) {
        Node cur = head, tail = head;

        while (cur != null) {
            Node child = cur.child;
            Node next = cur.next;
            if (child != null) {
                Node _tail = flattenRec(child);
                //adjusting child level's ending pointers.
                _tail.next = next;
                if (next != null) {
                    next.prev = _tail;
                }
                //adjusting child level's starting pointers.
                cur.next = child;
                child.prev = cur;
                cur.child = null; //after processing nullifying the child node.
                //skipping already processed child level's node.
                cur = _tail;
            } else {
                cur = next;
            }
            //making sure tail is not null.
            if (cur != null) {
                tail = cur;
            }
        }

        return tail;
    }
}
