class Solution {
    private TreeNode f(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (val < root.val) {
            if (root.left == null) root.left = new TreeNode(val);
            else f(root.left, val);
        } else {
            if (root.right == null) root.right = new TreeNode(val);
            else f(root.right, val);
        }

        return root;
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        return f(root, val);
    }
}
