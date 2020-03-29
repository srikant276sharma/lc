142. Linked List Cycle II [M]
https://leetcode.com/problems/linked-list-cycle-ii/

/*Solution 1: Using Floyd's Cycle Detection Algorithm.
*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        /*Check if cycle exists or not and if exists, then find the intersecting value. */
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {  /*Cycle detected. */
                break;
            }
        }
        
        /*There is no cycle. [Node: 1| Cycle index: -1], [1,2|-1] */
        if (fast == null || fast.next == null) {
            return null;
        }

        /*Find the start of the cycle. */
        ListNode ptr1 = head;
        ListNode ptr2 = slow;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }
}

--
Time complexity:  O(n), where n is number of nodes in List.
Space complexity: O(1).
--
Asked by: Amazom, Microsoft, NetApp.
--
