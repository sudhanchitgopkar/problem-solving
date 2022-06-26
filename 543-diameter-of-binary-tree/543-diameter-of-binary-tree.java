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
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        recurse(root);
        return max;
    } //diamOfBinTree
    
    public int recurse (TreeNode root) {
        if (root == null) return 0;
        int l = recurse(root.left);
        int r = recurse(root.right);
        if (l + r > max) max = l + r;
        return 1 + Math.max(l,r);
    } //recurse
} //Sol