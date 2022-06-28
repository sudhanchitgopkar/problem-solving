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
    public List<Integer> rightSideView(TreeNode root) {
        Queue <TreeNode> q = new LinkedList <TreeNode> ();
        List <Integer> sol = new ArrayList <Integer> ();
        
        if (root == null) return sol;
        q.add(root);
        
        while (!q.isEmpty()) {
            int len = q.size();
            TreeNode n = q.poll();
            sol.add(n.val);
            if (n.right != null) q.add(n.right);
            if (n.left != null) q.add(n.left);
            
            for (int i = 1; i < len; i++) {
                n = q.poll();
                if (n.right != null) q.add(n.right);
                if (n.left != null) q.add(n.left);
            } //for
        } //while
        
        return sol;
    } //rightSideView
} //Solution