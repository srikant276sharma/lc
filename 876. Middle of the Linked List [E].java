876. Middle of the Linked List [E]
https://leetcode.com/problems/middle-of-the-linked-list/

/*
*/

/*Solution 1.
1. fast moves 2 nodes at a time and slow moves 1 node at a time.
2. when fast reaches at the end of the LL, then slow will be at the middle of the list.
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

--
Time complexity: O(n) where n is the no. of nodes.
Space complexity: O(1).
--
Asked by:
--
