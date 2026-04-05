/**
 * Definition for a binary tree node.
 * public class TreeNode { ... }
 */

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        // Base Case 1: Both nodes are null. (SUCCESS)
        // We've reached the end of both trees simultaneously.
        if (p == null && q == null) {
            return true;
        }
        
        // Base Case 2: One node is null, or their values don't match. (FAILURE)
        // If the first check failed, at least one is non-null.
        // If one is null (XOR) OR the values are different, they are not the same.
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // Recursive Step: Both nodes are non-null and their values match.
        // Check if both the left subtrees AND the right subtrees are the same.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}