1008. Construct Binary Search Tree from Preorder Traversal [M]
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

/* Solution 1:
- First node of Preorder dataset is always root node.
- Then after root element, all those elements which are less than root node'value, are part of Left subtree of BST.
  and all those elements which are greater than root node'value, are part of Right subtree.

Knowledge Center: https://www.youtube.com/watch?v=GvPBasOr_mE 
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildBST(int[] preorder, int startIdx, int endIdx) {
        if (startIdx > endIdx)
            return null;

        /*In case of Preorder dataset, first element is always root. */
        TreeNode node = new TreeNode(preorder[startIdx]);
        if (startIdx == endIdx)
            return node;

        /*Find left subtree and right subtree index range. */
        int idx = startIdx + 1;
        while (idx <= endIdx && preorder[idx] < preorder[startIdx])
            idx++;

        node.left = buildBST(preorder, startIdx + 1, idx - 1);
        node.right = buildBST(preorder, idx, endIdx);
        return node;
    }
}

--
Complexities: Considering n is number of elements in the array.
Time: O(n).
Space: O(h), where h is height of BST.
--
Asked by:
--
