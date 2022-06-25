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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;
        
        Queue <TreeNode> pq = new LinkedList <TreeNode> ();
        Queue <TreeNode> qq = new LinkedList <TreeNode> ();
        
        pq.offer(p);
        qq.offer(q);
        
        while (!pq.isEmpty() && !qq.isEmpty()) {
            TreeNode pNode = pq.poll();
            TreeNode qNode = qq.poll();
            
            if (pNode == null && qNode != null) return false;
            else if (pNode != null && qNode == null) return false;
            else if (pNode == null && qNode == null) continue;
            else if (pNode.val != qNode.val) return false;
            
            pq.offer(pNode.left);
            qq.offer(qNode.left);
            pq.offer(pNode.right);
            qq.offer(qNode.right);
        } //while
        
        if (!pq.isEmpty() || !qq.isEmpty()) return false;
        return true;
    } //isSameTree
} //Sol