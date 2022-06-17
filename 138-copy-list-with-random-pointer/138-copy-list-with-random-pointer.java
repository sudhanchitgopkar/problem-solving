/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        HashMap <Node, Node> h = new  HashMap <Node, Node> ();
        
        Node curr = head;
        
        while (curr != null) {
            h.put(curr, new Node(curr.val));
            curr = curr.next;
        } //while
        
        curr = head;
        
        while (curr != null) {
            h.get(curr).next = h.get(curr.next);
            h.get(curr).random = h.get(curr.random);
            curr = curr.next;
        } //while
        
        return h.get(head);
    } //copyRandomList
} //Sol