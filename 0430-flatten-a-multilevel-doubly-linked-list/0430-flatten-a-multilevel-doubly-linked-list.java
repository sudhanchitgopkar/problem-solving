/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node temp = head;
        
        while (temp != null) {
            if (temp.child != null) {
                flatten(temp,temp.child,temp.next);
                temp.child = null;
            } //if
            temp = temp.next;
        } //while
        
        return head;
    } //flatten
    
    private void flatten(Node head, Node child, Node tail) {
        head.next = child;
        child.prev = head;
        Node prev = child;
        
        while (child != null) {
            if (child.child != null) {
                flatten(child,child.child,child.next);
                child.child = null;
            } //if
            prev = child;
            child = child.next;
        } //while
        
        prev.next = tail;
        if (tail != null) tail.prev = prev;
    } //flatten
} //Solution