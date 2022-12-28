class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue <Integer> pq = new PriorityQueue <> (Collections.reverseOrder());
        int sol = 0;
        for (int pile : piles) pq.offer(pile);
        while (k-- > 0) pq.offer(pq.peek() - pq.poll()/2);
        while (!pq.isEmpty()) sol += pq.poll();
        return sol;
    } //minStoneSum
} //Sol