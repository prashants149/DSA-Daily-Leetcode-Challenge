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
    long sum = 0;
    long maxp = 0;
    static final int MOD = 1000000007;

    private int totalsum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSubtreeSum = totalsum(root.left);
        int rightSubtreeSum = totalsum(root.right);
        return root.val + leftSubtreeSum + rightSubtreeSum;
    }

    private int find(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = find(root.left);
        int rightSum = find(root.right);

        long subtreeSum = root.val + leftSum + rightSum;
        long remainingSum = sum - subtreeSum;

        maxp = Math.max(maxp, subtreeSum * remainingSum);

        return (int) subtreeSum;
    }

    public int maxProduct(TreeNode root) {
        sum = totalsum(root);
        find(root);
        return (int)(maxp % MOD);
    }
}
