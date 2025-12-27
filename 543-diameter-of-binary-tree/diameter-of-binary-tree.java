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
    int sq = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        
        height(root);
        return sq;
    }
    private int height(TreeNode Node){
        if(Node == null){
            return 0;
        }
        int lh = height(Node.left);
        int rh = height(Node.right);
        sq = Math.max(sq, lh + rh);
        return Math.max(lh, rh) + 1;
        
    }
}