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
    int count = 0, sol = 0;
    public int kthSmallest(TreeNode root, int k) {
        recurse(root,k);
        return sol;
    } //kthSmallest
    
    private TreeNode recurse(TreeNode root, int k) {
        if (root == null) return root;
        
        recurse(root.left,k);
        if (++count == k) sol = root.val; 
        recurse(root.right,k);
        
        return root;
    } //recurse
} //Sol