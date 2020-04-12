23. Merge k Sorted Lists [H]
https://leetcode.com/problems/merge-k-sorted-lists/

/* Solution 1:
Using MinHeap.
B2B: https://www.youtube.com/watch?v=ptYUCjfNhJY
Amell: https://www.youtube.com/watch?v=tDn9O7UQ4E8
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        /*MinHeap will contain at most K nodes. */
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode node : lists) {
            if (node != null)
                pq.add(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode listNode = pq.poll();
            current.next = listNode;
            current = current.next;
            /*Add next node to the MinHeap. */
            if (listNode.next != null) {
                pq.add(listNode.next);
            }
        }

        return dummy.next;
    }
}

--
Complexities:

Time: O(2(n * log(k))) = O(n * log(k))
      Let n be the total elements across the k sorted arrays we are given.
      Extracting and adding to the Min Heap will both take log(k) time.
      For each of the n items, we will do an addition to the heap and removal from the heap (log(k) expense per heap operation).
      Hence the times 2. It is dropped. We get O(n * log(k)).

Space: O(k)
       Our heap will need to hold k elements for most of this process and cannot worsen past this.

We are not counting the size of the output array which uses O(n) space since that isn't core to our algorithm.
--
Asked by: Facebook, Amazon, Google, Microsoft, Oracle, Bloomberg, IXL, Adobe, Uber, Wish, Apple, LinkedIn, VMWare, Yahoo, Walmart Labs, Salesforce, Samsung, and Mathworks.
--
