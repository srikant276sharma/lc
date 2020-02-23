203. Remove Linked List Elements
https://leetcode.com/problems/remove-linked-list-elements/

/*
*/

/*Solution 1: Using dummy node. 
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

--
Time complexity: O(n) where n is the no. of nodes.
Space complexity: O(1).
--
Asked by: .
--
