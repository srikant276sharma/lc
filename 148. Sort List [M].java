148. Sort List [M]
https://leetcode.com/problems/sort-list/

/* Solution 1: Using Merge Sort.
Amell: https://www.youtube.com/watch?v=vH-o_6rwCEE

Time complexity: O(n log n), where n is number of nodes in the list.
Space complexity: It will take memory due to recursive call.

Asked by:
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode preSlow = null, slow = head, fast = head;
        //find the midpoint of the linked list, 'slow'.
        while (fast != null && fast.next != null) {
            preSlow = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        //split the linked list into 2 lists, 1st one starts from head and 2nd one starts from slow.
        preSlow.next = null;

        //sort each half.
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        //merge l1 and l2;
        return merge(l1, l2);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        //merge the two lists.
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        //if any one of the list still has any node then add them.
        cur.next = (l1 != null) ? l1 : l2;

        return dummy.next;
    }
}
