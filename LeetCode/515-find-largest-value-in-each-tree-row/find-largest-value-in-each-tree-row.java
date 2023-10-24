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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> sol = new ArrayList <> ();
        Queue <TreeNode> q = new LinkedList <> ();

        if (root == null) return sol;
        else q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size(), rowMax = Integer.MIN_VALUE;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                rowMax = rowMax > curr.val ? rowMax : curr.val;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            } //for
            
            sol.add(rowMax);
        } //while

        return sol;
    } //largestVals
} //Sol