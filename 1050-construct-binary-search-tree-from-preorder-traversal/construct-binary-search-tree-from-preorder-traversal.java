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
    int ind = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return f(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE); 
    }
    private TreeNode f(int[]preorder, int lower,int upper){
        if(ind==preorder.length) return null ;
        int nodeval = preorder[ind];
        if (nodeval < lower || nodeval > upper) return null;
        TreeNode node = new TreeNode(nodeval);
        ind++;
        
        node.left = f(preorder,lower,nodeval);
        node.right = f(preorder,nodeval,upper);

        return node;

        

    }
}