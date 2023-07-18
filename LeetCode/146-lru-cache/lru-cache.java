class LRUCache {
    HashMap <Integer, Node> hm = new HashMap <> ();
    Node LRU = null, MRU = null;
    int size = 0, cap = 0;

    public LRUCache(int capacity) {
        cap = capacity;
    } //constructor
    
    public int get(int key) {
        if (hm.containsKey(key)) {
            Node curr = hm.get(key);

            if (curr.val == -1) {
                return -1;
            } else if (LRU == curr && size > 1) {
                LRU = LRU.next;
            } else if (curr == MRU) {
                return MRU.val;
            } //if

            if (curr.next != null) curr.next.prev = curr.prev;
            if (curr.prev != null) curr.prev.next = curr.next;
            curr.next = null;
            curr.prev = MRU;
            MRU.next = curr;
            MRU = curr;
            return MRU.val;
        } else {
            return -1;
        } //if
    } //get
    
    public void put(int key, int value) {
        if (get(key) == -1) {
            Node newNode = new Node (null, MRU, value);
            hm.put(key, newNode);
            if (LRU == null) LRU = newNode;
            if (MRU == null) {
                MRU = newNode;   
            } else {
                MRU.next = newNode;
                MRU = MRU.next;
            } //if

            if (++size > cap) {
                LRU.val = -1;
                LRU = LRU.next;
                --size;
            } //if
        } else {
            MRU.val = value;
        } //if
    } //put
} //LRUCache

class Node {
    protected Node next, prev;
    int val;

    public Node(Node next, Node prev, int val) {
        this.next = next;
        this.prev = prev;
        this.val = val;
    } //Node
} //Node

