class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        HashMap <Integer, Integer> freq = new HashMap <Integer, Integer> ();
        PriorityQueue <Integer> min = new PriorityQueue<Integer> ();
        
        for (int card : hand) {
            min.offer(card);
            if (freq.containsKey(card)) {
                freq.put(card, freq.get(card) + 1);
            } else {
                freq.put(card,1);
            } //if
        } //for
        
        while (!min.isEmpty()) {
            int currMin = min.poll();
            if (freq.get(currMin) == 0) {
                continue;
            } //if
            freq.put(currMin,freq.get(currMin) - 1);
            for (int i = 1; i < groupSize; i++) {
                if ((!freq.containsKey(currMin + i)) || freq.get(currMin + i) == 0) return false;
                else freq.put(currMin + i, freq.get(currMin + i) - 1);
            } //for
        } //while
        
        return true;
    } //isNStraightHand
} //Sol