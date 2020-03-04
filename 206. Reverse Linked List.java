206. Reverse Linked List
https://leetcode.com/problems/reverse-linked-list/

/*Solution: 1
Assume that we have linked list 1 → 2 → 3 → Ø, we would like to change it to Ø ← 1 ← 2 ← 3.
While you are traversing the list, 
change the current node's next pointer to point to its previous element. 
Since a node does not have reference to its previous node, you must store its previous element beforehand. 
You also need another pointer to store the next node before changing the reference. 
Do not forget to return the new head reference at the end! */

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
        ListNode nextN = null;
        ListNode prevN = null;
        
        while (cur != null) {
            nextN = cur.next; //Store current node's next node as backup for next iteration.
            cur.next = prevN; //Set previous node as current node's next node.
            prevN = cur; //Set current node as previous node for next iteration.
            cur = nextN; //Iterate to next node.
        }
        return prevN; //Return new head.
    }
}
--
Complexity analysis
Time complexity : O(n). Assume that nn is the list's length, the time complexity is O(n).
Space complexity : O(1).
--
Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
Memory Usage: 37.5 MB, less than 96.40% of Java online submissions for Reverse Linked List.
--
