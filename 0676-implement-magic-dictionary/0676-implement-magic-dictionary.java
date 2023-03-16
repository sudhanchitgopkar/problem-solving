class MagicDictionary {
    Node root;

    public MagicDictionary() {
        root  = new Node (' ',null);
    }
    
    public void buildDict(String[] dictionary) {
        for (String s : dictionary) addString(root,s+'{',0);
    } //build
    
    public boolean search(String w) {
         for (int i = 0; i < 27; i++) 
            if (root.children[i] != null) 
                if (check(root.children[i],w+'{',0,0)) return true;
         return false;
    }

    public void addString(Node root, String s, int loc) {
        if (loc == s.length()) return;
        int idx = s.charAt(loc)-'a';
        if (root.children[idx] == null) {
            root.children[idx] = new Node(s.charAt(loc),root);
        }
        addString(root.children[idx],s,loc+1);
    } //addString

    public boolean check(Node root, String s, int numChanges, int idx) {
       if (idx == s.length() - 1 && root != null && 
            root.val == '{' && numChanges == 1) return true;
       if (root == null || idx == s.length() - 1 || numChanges > 1) return false;

       if (root.val != s.charAt(idx)) numChanges++;
       for (int i = 0; i < 27; i++)
            if (check(root.children[i], s, numChanges, idx + 1)) return true;

       return false;
    } //check
}

public class Node {
    protected char val;
    protected Node parent;
    protected Node [] children;

    public Node (char val, Node parent) {
        this.val = val;
        this.parent = parent;
        children = new Node [27];
    } //const

    public void addChild(Node child) {
        children[child.val-'a'] = child;
    } //child

} //Node

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */