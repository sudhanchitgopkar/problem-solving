class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        int n = getSize(root);
        Queue <Tuple> q = new LinkedList <> ();
        TreeNode [] parents = new TreeNode [n + 1];
        boolean [] seen = new boolean [n + 1];
        setParents(root, parents);
        Tuple start = new Tuple(findStart(root, startValue), "");

        q.offer(start);

        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            seen[curr.node.val] = true;
            if (curr.node.val == destValue) 
                return curr.dirs;
            if (curr.node.left != null && !seen[curr.node.left.val]) 
                q.offer(new Tuple(curr.node.left, curr.dirs + "L"));
            if (curr.node.right != null && !seen[curr.node.right.val]) 
                q.offer(new Tuple(curr.node.right, curr.dirs + "R"));
            if (parents[curr.node.val] != null && !seen[parents[curr.node.val].val])
                q.offer(new Tuple(parents[curr.node.val], curr.dirs + "U"));
        } //while

        return "Something went wrong!";
    } //getDir

    private int getSize(TreeNode root) {
        int size = 0;
        Queue <TreeNode> q = new LinkedList <> ();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            ++size;
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        } //while

        return size;
    } //getSize

    private void setParents(TreeNode root, TreeNode [] parents) {
        Queue <TreeNode> q = new LinkedList <> ();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) {
                parents[curr.left.val] = curr;
                q.offer(curr.left);
            } //if
            if (curr.right != null) {
                parents[curr.right.val] = curr;
                q.offer(curr.right);
            } //if
        } //while
    } //setParents

    private TreeNode findStart(TreeNode root, int start) {
        Queue <TreeNode> q = new LinkedList <> ();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.val == start) return curr;
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        } //while

        return new TreeNode (-1); //impossible!
    } //findStart
} //Sol

class Tuple {
    protected TreeNode node;
    protected String dirs;

    public Tuple(TreeNode node, String dirs) {
        this.node = node;
        this.dirs = dirs;
    } //Tuple
} //Tuple