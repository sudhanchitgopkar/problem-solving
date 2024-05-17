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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return remover(root, target) ? null : root;
    } //removeLeafNodes

    private boolean remover(TreeNode tn, int target) {
        if (tn == null) return false;
        if (tn.left == null && tn.right == null && tn.val == target) return true;

        if (remover(tn.left, target)) tn.left = null;
        if (remover(tn.right, target)) tn.right = null;
        if (tn.left == null && tn.right == null && tn.val == target) return true;
        else return false;
    } //remover
} //Sol