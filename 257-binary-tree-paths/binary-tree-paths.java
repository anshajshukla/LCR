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
    List<String> l = new ArrayList<>();
    private void f(TreeNode root,StringBuilder str){
        int len = str.length();
        if(root==null) return;
        if(root.left==null && root.right==null) {
            if (len > 0) str.append("->");
            str.append(root.val);
            l.add(str.toString());
            str.setLength(len);
            return;
        }
        
        if (len > 0) str.append("->");
        str.append(root.val);
        f(root.left,str);
        f(root.right,str);
        str.setLength(len);

    }
    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder str = new StringBuilder();
        f(root,str);
        return l;


        
    }
}