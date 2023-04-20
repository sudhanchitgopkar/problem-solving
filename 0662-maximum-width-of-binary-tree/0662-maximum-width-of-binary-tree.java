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
    public int widthOfBinaryTree(TreeNode root) {
        Queue <TreeNode> q = new LinkedList <> ();
        int sol = 1;
        root.val = 1; //init position = 1;

        q.add(root);

        while (!q.isEmpty()) {
            int lvl = q.size(), l = Integer.MAX_VALUE, w = -1;
            for (int i = 0; i < lvl; i++) {
                TreeNode curr = q.poll();
                if (i == 0) l = curr.val; //set l to leftmost node position
                else w = curr.val - l + 1;

                if (curr.left != null) {
                    curr.left.val = (curr.val * 2) - 1; //color it
                    q.add(curr.left); //add it
                } //if

                if (curr.right != null) {
                    curr.right.val = (curr.val * 2); //color it
                    q.add(curr.right); //add it
                } //if
            } //for
            sol = w > sol ? w : sol;
        } //while
        return sol;
    } //width
} //Sol

//r = p * 2
//l = p * 2 - 1