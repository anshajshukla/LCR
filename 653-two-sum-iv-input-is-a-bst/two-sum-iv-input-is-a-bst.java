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
    boolean ans = false;
    private void f(TreeNode root,int k ,HashSet<Integer> h){
        if(root==null) return;
        int l = k-root.val;
        if(h.contains(l)) ans = true;
        h.add(root.val);
        f(root.left,k,h);
        f(root.right,k,h);
    }
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> h = new HashSet<>();
        f(root,k,h);
        return ans;
        
    }
}