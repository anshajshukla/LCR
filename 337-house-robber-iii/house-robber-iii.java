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
    private int[] travel(TreeNode root){
        if(root==null) return new int[2];

        int[] left_node = travel(root.left);
        int[] right_node = travel(root.right);
        int [] option = new int[2];
        // option 0 --> we are robbing this house 
        option[0] = root.val + left_node[1] + right_node[1];
        // option 2 --> we are not robbing this so we have no choices we can rob the child too or not 
        //              thats why we are using math.max in the child node cause we can rob it or not rob it 
        option[1] = Math.max(left_node[0],left_node[1]) + Math.max(right_node[0],right_node[1]);

        return option;



    }
    public int rob(TreeNode root) {
        int [] option = new int[2];
        option = travel(root);
        return Math.max(option[0],option[1]);  // basically take and notTake 

    }
}