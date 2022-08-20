class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0; 
        int lvl = 1;
        Queue <Integer> q = new LinkedList <Integer> ();
        HashSet <Integer> seen = new HashSet <Integer> ();
        for (int coin : coins) q.offer(coin);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                if (curr == amount) {
                    return lvl;
                } else if (curr < amount && !seen.contains(curr)) {
                    for (int coin : coins) {
                        q.offer (curr + coin);
                    } //for
                    seen.add(curr);
                } //if
            } //for
            lvl++;
        } //while
        
        return -1;
    } //coinChange 
} //Solution