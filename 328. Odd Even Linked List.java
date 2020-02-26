328. Odd Even Linked List
https://leetcode.com/problems/odd-even-linked-list/

/*Solution 1.

Algorithm:

1. Create 2 ListNode pointers that will walk the original list:
- odd will build the odd list
- even will build the even list
2. We also need to keep track of both list heads:
- head will keep track of the odd list head
- ListNode evenHead (which we will create) will keep track of the even list head
3. After we build both lists, connect the even list to the end of the odd list.

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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}

--
Time complexity: O(n). There are total n nodes and we visit each node once.
Space complexity: O(1). All we need is the four pointers.
--
Asked by: .
--
