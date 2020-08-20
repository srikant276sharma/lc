143. Reorder List [M]
https://leetcode.com/problems/reorder-list/

/* Solution 1:
KC: https://www.youtube.com/watch?v=meOY1wajrnw

TC: O(n), where n = number of nodes in the list.
SC: O(1).
*/

class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        //Find mid node.
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse second half.
        ListNode prev = null, curr = slow, tmp;
        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        //Rearrange wiring.
        ListNode n1 = head, n2 = prev;
        while (n2.next != null) {
            tmp = n1.next;
            n1.next = n2;
            n1 = tmp;

            tmp = n2.next;
            n2.next = n1;
            n2 = tmp;
        }
    }
}
