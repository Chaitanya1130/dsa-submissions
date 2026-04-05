class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            // Case 1 & 2: Node has one or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            
            TreeNode cur = root.right;
            while (cur.left != null) cur = cur.left;

            root.val = cur.val; 
            root.right = deleteNode(root.right, root.val); // delete successor
        }

        return root; 
    }
}
