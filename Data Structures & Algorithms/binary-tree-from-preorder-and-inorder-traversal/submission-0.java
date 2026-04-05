/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int preIdx = 0;  // tracks current root in preorder

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, inorder, 0, inorder.length - 1);
    }
    private TreeNode construct(int[] preorder, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        // pick root from preorder
        TreeNode root = new TreeNode(preorder[preIdx++]);

        // find root index in inorder to split left and right subtree
        int inIdx = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIdx = i;
                break;
            }
        }

        // build left and right recursively
        root.left = construct(preorder, inorder, inStart, inIdx - 1);
        root.right = construct(preorder, inorder, inIdx + 1, inEnd);

        return root;
    }

}
