class Trie {
    Node root;
    
    public Trie() {
        root = new Node (null, ' ');
    } //Trie
    
    public void insert(String s) {
        insert(root, s, 0);
    } //insert
    
    public boolean search(String s) {
        return search (root, s, 0);
    } //search
    
    public boolean startsWith(String s) {
        return prefix(root, s, 0);
    } //startsWith

    private void insert(Node root, String s, int loc) {
        if (loc == s.length()) return;
        int idx = s.charAt(loc)-'a';
        if (root.children[idx] == null) root.children[idx] = new Node(root,s.charAt(loc));
        if (loc == s.length() - 1) root.children[idx].setTerminal();
        insert(root.children[idx], s, loc + 1);
    } //insert

    private boolean search(Node root, String s, int loc) {
        if (loc == s.length()) return false;
        int idx = s.charAt(loc)-'a';
        if (loc == s.length() - 1 && root.children[idx] != null
             && root.children[idx].terminal) return true;
        if (root.children[idx] == null) return false;
        return search(root.children[idx], s, loc + 1);
    } //search

    private boolean prefix(Node root, String s, int loc) {
        if (loc == s.length()) return false;
        int idx = s.charAt(loc)-'a';
        if (loc == s.length() - 1 && root.children[idx] != null) return true;
        if (root.children[idx] == null) return false;
        return prefix(root.children[idx], s, loc + 1);
    } //search
} //Trie

public class Node {
    protected Node parent;
    protected Node [] children;
    protected char val;
    protected boolean terminal;

    public Node (Node parent, char val) {
        this.parent = parent;
        this.val = val;
        children = new Node [26];
        terminal = false;
    } //constructor

    public void addChild(Node child) {
        children[child.val-'a'] = child;
    } //addChild

    public void setTerminal() {
        terminal = true;
    } //setTerminal
} //class

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */