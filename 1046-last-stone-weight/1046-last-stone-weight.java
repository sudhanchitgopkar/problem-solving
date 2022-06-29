class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue <Integer> pq = new PriorityQueue <Integer> (Collections.reverseOrder());
        
        for (int stone : stones) {
            pq.offer(stone);
        } //for
        
        while (pq.size() > 1) {
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            
            if (stone1 == stone2) {
                continue;
            } else {
                pq.offer(stone1-stone2);
            } //if
        } //while
        
        if (pq.size() == 0) return 0;
        return pq.poll();
    } //lastStoneWeight
} //Sol