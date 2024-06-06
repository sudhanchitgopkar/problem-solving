class Solution {
    public boolean isNStraightHand(int[] hand, int k) {
        int n = hand.length;
        HashMap <Integer, Integer> freq = new HashMap <> ();
        PriorityQueue <Integer> pq = new PriorityQueue <> (); 

        if (n % k != 0) return false;

        for (int card : hand) {
            pq.offer(card);
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        } //for

        do {
            int curr = pq.poll();
            while (freq.get(curr) <= 0) {
                if (pq.isEmpty()) return true;
                curr = pq.poll();
            } //while
            freq.put(curr, freq.get(curr) - 1);
            
            for (int i = 1; i < k; i++) {
                if (!freq.containsKey(++curr) || freq.get(curr) == 0) return false;
                else freq.put(curr, freq.get(curr) - 1);
            } //for
        }
        while (!pq.isEmpty());
        
        return true;
    } //isN
} //Sol