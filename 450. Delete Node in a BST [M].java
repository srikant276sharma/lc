450. Delete Node in a BST [M]
https://leetcode.com/problems/delete-node-in-a-bst/

/* Solution 1:
KC: https://www.youtube.com/watch?v=LyHK6_I3aUY&pp=wgIECgIIAQ%3D%3D
or Premium article.

TC: O(H), where H is height of the Tree, equal to log⁡N in case of a balanced tree.
SC: O(H), to keep the recursion stack.
*/

class Solution {
  /*
  One step right and then always left
  */
  public int successor(TreeNode root) {
    root = root.right;
    while (root.left != null) 
        root = root.left;
    return root.val;
  }

  /*
  One step left and then always right
  */
  public int predecessor(TreeNode root) {
    root = root.left;
    while (root.right != null) 
        root = root.right;
    return root.val;
  }

  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null) return null;

    // delete from the right subtree
    if (key > root.val) 
        root.right = deleteNode(root.right, key);
    // delete from the left subtree
    else if (key < root.val) 
        root.left = deleteNode(root.left, key);
    // delete the current node
    else {
      // the node is a leaf
      if (root.left == null && root.right == null) 
        root = null;
      // the node is not a leaf and has a right child
      else if (root.right != null) {
        root.val = successor(root);
        root.right = deleteNode(root.right, root.val);
      }
      // the node is not a leaf, has no right child, and has a left child    
      else {
        root.val = predecessor(root);
        root.left = deleteNode(root.left, root.val);
      }
    }
    return root;
  }
}
