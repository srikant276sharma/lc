206. Reverse Linked List [E]
https://leetcode.com/problems/reverse-linked-list/

/*Solution: 1
Assume that we have linked list 1 → 2 → 3 → Ø, we would like to change it to Ø ← 1 ← 2 ← 3.
While you are traversing the list, 
change the current node's next pointer to point to its previous element. 
Since a node does not have reference to its previous node, you must store its previous element beforehand. 
You also need another pointer to store the next node before changing the reference. 
Do not forget to return the new head reference at the end! */

TC: O(n). Assume that n is the list's length, the time complexity is O(n).
SC: O(1).

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prevNode = null;

        while (cur != null) {
            ListNode tempNext = cur.next; //Store cur.next as backup for next iteration.
            cur.next = prevNode; //Set prevNode as current node's next node.
            prevNode = cur; //Set current node as prevNode for next iteration.
            cur = tempNext; //Iterate to next node.
        }
        return prevNode; //Return new head.
    }
}
