1290. Convert Binary Number in a Linked List to Integer
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

/*
*/

/*Solution 1.
1. use Signed left shift operator (<<).
2. use Bitwise inclusive OR operation (|).
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
    public int getDecimalValue(ListNode head) {
        int decVal = 0;
        while (head != null) {
            decVal = decVal << 1;
            decVal = decVal | head.val;
            head = head.next;
        }
        return decVal;
    }
}

--
Time complexity: O(n) where n is the no. of nodes.
Space complexity: O(1).
--
Asked by:.
--
