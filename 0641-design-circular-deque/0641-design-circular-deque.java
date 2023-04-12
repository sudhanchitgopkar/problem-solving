class MyCircularDeque {
    int [] cdq;
    int l, f, size;
    public MyCircularDeque(int k) {
        cdq = new int [k+1];
        f = 0;
        l = 1;
        size = 0;
    } //constructor
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        cdq[f] = value;
        if (--f == -1) f = cdq.length-1;
        size++;
        return true;
    } //insertFront
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        cdq[l] = value;
        if (++l >= cdq.length) l = 0;
        size++;
        return true;
    } //insertLast
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        f = ++f >= cdq.length ? 0 : f;
        size--;
        return true;
    } //deleteFront
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        l = --l < 0 ? cdq.length - 1 : l;
        size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return cdq[(f + 1) % cdq.length];
    }
    
    public int getRear() {        
        if (isEmpty()) return -1;
        return cdq[(l - 1) < 0 ? cdq.length-1 : l - 1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == cdq.length-1;
    } //isFull
} 

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */