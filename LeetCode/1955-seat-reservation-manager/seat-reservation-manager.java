class SeatManager {
    PriorityQueue <Integer> available = new PriorityQueue <> ();
    public SeatManager(int n) {
        for (int i = 1; i <= n; i++) {
            available.offer(i);
        } //for
    } //SM
    
    public int reserve() {
        return available.poll();
    } //reserve
    
    public void unreserve(int seatNumber) {
        available.offer(seatNumber);
    } //unreserve
} //SeatManager

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */