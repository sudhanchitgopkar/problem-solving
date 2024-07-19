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
    int sol = 0;
    public int countPairs(TreeNode root, int distance) {
        DLNode DLRoot = initParents(root, new DLNode(null, null, root.val, null));
        dfs(DLRoot, distance);
        return sol/2;
    } //countPairs

    private void dfs(DLNode root, int maxDist) {
        if (root.left == null && root.right == null) {
            if (root.parent != null) findPairs(root.parent, root, 1, maxDist);
        } //if

        if (root.left != null) dfs(root.left, maxDist);
        if (root.right != null) dfs(root.right, maxDist);
    } //dfs

    private void findPairs(DLNode curr, DLNode prev, int currDist, int maxDist) {
        if (currDist > maxDist) return;
        if (curr.left == null && curr.right == null) {
            ++sol;
        }

        if (curr.parent != prev &&
            curr.parent != null) findPairs(curr.parent, curr, currDist + 1, maxDist);
        if (curr.left != prev && 
            curr.left != null) findPairs(curr.left, curr, currDist + 1, maxDist);
        if (curr.right != prev && 
            curr.right != null) findPairs(curr.right, curr, currDist + 1, maxDist);
    } //findPairs

    private DLNode initParents(TreeNode root, DLNode curr) {
        if (root.left != null) {
            curr.left = new DLNode(null, null, root.left.val, curr);
            initParents(root.left, curr.left);
        } //if

        if (root.right != null) {
            curr.right = new DLNode(null, null, root.right.val, curr);
            initParents(root.right, curr.right);
        } //if

        return curr;
    } //initParents
} //Sol

class DLNode {
    protected DLNode left, right;
    protected int val;
    protected DLNode parent;
    public DLNode (DLNode l, DLNode r, int val, DLNode parent) {
        this.left = l;
        this.right = r;
        this.val = val;
        this.parent = parent;
    } //DLNode
} //Node