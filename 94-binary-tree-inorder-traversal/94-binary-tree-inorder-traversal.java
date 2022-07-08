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
    List<Integer> sol;
    public List<Integer> inorderTraversal(TreeNode root) {
        sol = new ArrayList<Integer>();
        dfs(root);
        return sol;
    } //inorderTraversal
    
    private void dfs (TreeNode root) {
        if (root == null) return;
        
        dfs(root.left);
        sol.add(root.val);
        dfs(root.right);
        
        return;
    } //sol
} //Sol