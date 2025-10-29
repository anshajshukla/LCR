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
    int ans = 0;
    private void f(TreeNode root, StringBuilder str){
        if(root==null) return;
        if(root.right==null && root.left==null) {
            str.append(root.val);
            ans+=Integer.parseInt(str.toString());
            str.deleteCharAt(str.length()-1);
            return;
        }
        str.append(root.val);
        f(root.left,str);
        f(root.right,str);
        str.deleteCharAt(str.length()-1);
    }
    public int sumNumbers(TreeNode root) {
        StringBuilder str = new StringBuilder();
        f(root,str);
        return ans;
        
    }
}