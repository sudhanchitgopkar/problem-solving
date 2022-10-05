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
    public boolean hasPathSum(TreeNode root, int target) {
        if (root == null) return false;
        if (target - root.val == 0 && root.left == null && root.right == null) return true;
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
    } //hasPathSum
    
    public boolean check(TreeNode root, int target, int sum) {
        if (root == null) return false;
        if (sum + root.val == target && root.left == null && root.right == null) return true;
        return check(root.left, target, sum + root.val) || check(root.right, target, sum + root.val);
    } //check
}