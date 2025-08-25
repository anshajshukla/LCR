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
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        return f(nums,start,end);        
    }
    private static TreeNode f(int nums[],int start ,int end){
        int mid = start + (end-start)/2;
        TreeNode tree = new TreeNode();
        
        if(start>end) return null;
        tree.val = nums[mid];
        tree.left = f(nums,start,mid-1);
        tree.right = f(nums,mid+1,end);

        return tree;

    }
}