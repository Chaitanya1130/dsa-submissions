class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return helper(root, root.val);
    }

    private int helper(TreeNode root, int maxSoFar) {
        if (root == null) return 0;

        int count = 0;
        if (root.val >= maxSoFar) {
            count = 1; // current node is good
        }

        // recursively check left and right without loops
        count += helper(root.left, Math.max(maxSoFar, root.val));
        count += helper(root.right, Math.max(maxSoFar, root.val));

        return count;
    }
}
