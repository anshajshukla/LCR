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
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return h(preorder,0,preorder.length-1,map);
    }
    private TreeNode h(int [] preorder,int start,int end,HashMap<Integer, Integer> map){
        if(start>end) return null;
        int rootval = preorder[index];
        index++;
        TreeNode node = new TreeNode(rootval);

        int pos = map.get(rootval);

        node.left = h(preorder,start,pos-1,map);
        node.right = h(preorder,pos+1,end,map);

        return node;

    }

        
        
}
