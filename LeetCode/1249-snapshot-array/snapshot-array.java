class SnapshotArray {
    List<List<Snapshot>> history;
    int currId;
    public SnapshotArray(int length) {
        history = new ArrayList<List<Snapshot>> ();

        for (int i = 0; i < length; i++) {
            history.add(new ArrayList<Snapshot> ());
        } //for
    } //SnapshotArr
    
    public void set(int index, int val) {
        int lastSnapIdx = history.get(index).size() - 1;
        if (lastSnapIdx == -1 || 
            history.get(index).get(lastSnapIdx).snapId != currId) {
                history.get(index).add(new Snapshot(currId, val));
        } else {
            history.get(index).set(lastSnapIdx, new Snapshot(currId, val));
        } //if
    } //set
    
    public int snap() {
        return currId++;
    } //snap
    
    public int get(int index, int snap_id) {
        int val = 0, l = 0, r = history.get(index).size() - 1;
        
        while (l <= r) {
            int m = l + (r - l)/2;
            if (history.get(index).get(m).snapId == snap_id) {
                return history.get(index).get(m).val;
            } else if (history.get(index).get(m).snapId < snap_id) {
                val = history.get(index).get(m).val;
                l = ++m;
            } else {
                r = --m;
            } //if
        } //while

        return val;
    } //get
} //SnapshotArray

class Snapshot {
    protected int snapId, val;

    public Snapshot(int snapId, int val) {
        this.snapId = snapId;
        this.val = val;
    } //Snapshot
} //Snapshot

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */