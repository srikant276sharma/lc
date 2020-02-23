160. Intersection of Two Linked Lists
https://leetcode.com/problems/intersection-of-two-linked-lists/

/*
*/

/*Solution 1.
1. calculate length of both LLs as aLen and bLen.
2. calculate the difference lenDiff = |aLen - bLen|.
3. Move lenDiff nodes in longer LL.
4. Then move by 1 step in both LLs till a = b.
Note: here reference of a and b should be same, not value.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;
        int aLen = length(headA);
        int bLen = length(headB);
        int lenDiff = Math.abs(aLen - bLen);

        if (aLen > bLen) {
            for (int i = 0; i < lenDiff; i++) {
                a = a.next;
            }
        } else if (aLen < bLen) {
            for (int i = 0; i < lenDiff; i++) {
                b = b.next;
            }
        }

        while (a != null && b != null) {
            if (a == b) {
                return a;
            }
            a = a.next;
            b = b.next;
        }
        return null;
    }

    private int length(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;
    }
}

--
Time complexity: O(n + m) where n is the no. of nodes in headA and m is the no. of nodes in headB.
Space complexity: O(1).
--
Asked by: Amazon, Microsoft, Bloomberg, Oracle, Yahoo and ByteDance.
--
