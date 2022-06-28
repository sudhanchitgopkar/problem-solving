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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue <TreeNode> q = new LinkedList <TreeNode> ();
        List<List<Integer>> sol = new ArrayList<List<Integer>> ();
        
        if (root == null) return sol;
        q.add(root);
        
        while (!q.isEmpty()) {
            int qlen = q.size();
            ArrayList<Integer> l = new ArrayList<Integer>();
            
            for (int i = 0; i < qlen; i++) {
                TreeNode n = q.poll();
                l.add(n.val);
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            } //for
            
            sol.add(l);
        } //while
        
        return sol;
    } //levelOrder
} //Solution