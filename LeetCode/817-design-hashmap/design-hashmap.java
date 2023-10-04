class MyHashMap {
    List<List<int []>> hm;
    HashSet <Integer> usedKeys;

    public MyHashMap() {
        hm = new ArrayList<List<int []>> ();
        usedKeys = new HashSet <> ();
        
        for (int i = 0; i < 10; i++) {
            hm.add(new ArrayList<int []>());
        } //for 
    } //myhm
    
    public void put(int key, int value) {
        if (usedKeys.contains(key)) {
            remove(key);
        } //if

        hm.get(key % 10).add(new int [] {key, value});
        usedKeys.add(key);
    } //for
    
    public int get(int key) {
        for (int [] entry : hm.get(key % 10)) {
            if (entry[0] == key) {
                return entry[1];
            } //if
        } //for
        return -1;
    } //get
    
    public void remove(int key) {
        for (int i = 0; i < hm.get(key % 10).size(); i++) {
            if (hm.get(key % 10).get(i)[0] == key) {
                hm.get(key % 10).remove(i);
                break;
            } //if
        } //for
    } //remove
} //myHashMap

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */