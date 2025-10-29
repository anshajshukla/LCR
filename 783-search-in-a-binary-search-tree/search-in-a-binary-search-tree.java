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
    TreeNode ans = null;
    private void f(TreeNode root,int v){
        if(root==null) return;
        if(root.val==v) {
            ans = root;
            return;
        }
        f(root.left,v);
        f(root.right,v);
        

    }
    public TreeNode searchBST(TreeNode root, int v) {
        f(root,v);
        return ans;

        
        
        
    }
}