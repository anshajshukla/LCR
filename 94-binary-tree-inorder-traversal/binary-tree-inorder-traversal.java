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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> l = new ArrayList<>();
        f(l,root);
        return l;
        
    }
    private void f(List<Integer> l,TreeNode root){
        if (root == null) return;
        f(l,root.left);
        l.add(root.val);
        f(l,root.right);
    }
}