108. Convert Sorted Array to Binary Search Tree [E]
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

/* Solution: 1 : 
Algorithm:
1. Initialize start = 0, end = length of the array - 1
2. Set mid = (start+end)/2
3. Create a tree node with mid as root (lets call it A).
4. Recursively do following steps:
   a). Calculate mid of left subarray and make it root of left subtree of A.
   b). Calculate mid of right subarray and make it root of right subtree of A.
*/   

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode current = new TreeNode(nums[mid]);
        current.left = constructBST(nums, left, mid - 1);
        current.right = constructBST(nums, mid + 1, right);
        return current;
    }
}

/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Sorted Array to Binary Search Tree.
Memory Usage: 45.2 MB, less than 5.16% of Java online submissions for Convert Sorted Array to Binary Search Tree.
--
Time Complexity: O(n)
Space Complexity: O(n) since we're creating a Binary Search Tree.
--
Asked by: Google, Apple.
*/
