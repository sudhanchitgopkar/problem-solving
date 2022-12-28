class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int extras) {
        for (int i = 0; i < capacity.length; i++) capacity[i] -= rocks[i];
        Arrays.sort(capacity);
        int sol = 0;

        for (int i = 0; i < capacity.length && extras > 0; i++) {
            if (extras >= capacity[i]) {
                    extras -= capacity[i];
                    capacity[i] = 0;
                    sol++;
            } //if
        } //for
        
        return sol;
    } //maxBags
} //Sol