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
    List<List<Integer>> ans = new ArrayList<>();
    private void f(TreeNode root, int t, List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && t == root.val) {
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        f(root.left, t - root.val, list);
        f(root.right, t - root.val, list);
        list.remove(list.size() - 1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int t) {
        List<Integer> l = new ArrayList<>();
        f(root,t,l);
        return ans;
    }
}