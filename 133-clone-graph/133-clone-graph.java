/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap <Node,Node> oldToNew = new HashMap <Node,Node> ();
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        if (!oldToNew.containsKey(node)) {
            Node copy = new Node (node.val);
            oldToNew.put(node,copy);
        } else {
            return oldToNew.get(node);
        } //if
        
        for (Node neighbor : node.neighbors) {
            oldToNew.get(node).neighbors.add(cloneGraph(neighbor));
        } //for
        
        return oldToNew.get(node);
    } //cloneGraph
} //Sol