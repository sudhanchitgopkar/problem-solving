class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        PriorityQueue <Integer> pq = new PriorityQueue <Integer> (Collections.reverseOrder());
        HashMap <Integer, Integer> freq = new HashMap <Integer, Integer> ();
        int sol = 0;
        
        for (int [] box : boxTypes) {
            if (freq.get(box[1]) == null) {
                freq.put(box[1],box[0]);
                pq.offer(box[1]);
            } else {
                freq.put(box[1],freq.get(box[1]) + box[0]);
            } //if
        } //for
        
        while (truckSize > 0 && !pq.isEmpty()) {
            sol += pq.peek();
            freq.put(pq.peek(),freq.get(pq.peek())-1);
            if (freq.get(pq.peek()) == 0) pq.poll();
            truckSize--;
        } //while
        
        return sol;
    } //maxUnits
} //Sol