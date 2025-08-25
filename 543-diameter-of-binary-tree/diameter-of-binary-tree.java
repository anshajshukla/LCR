class Solution {
    private int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dia;
    }
    private int height(TreeNode node) {
        if (node == null) return 0;
        int left = height(node.left);
        int right = height(node.right);
        dia = Math.max(dia, left + right);
        return 1 + Math.max(left, right);  // this will return the height of the tree so if we return it direclty it will not be a diameter
    }
}
