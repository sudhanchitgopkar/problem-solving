class Solution {
    public int findTheWinner(int n, int k) {
        boolean [] friends = new boolean [n + 1];
        for (int i = 0; i < n + 1; i++) friends[i] = true;
        int curr = 1;

        while (!hasWinner(friends)) {
            curr = iter(curr, k - 1, friends);
            int temp = curr;
            curr = iter(curr, 1, friends);
            friends[temp] = false;
        } //while
        
        return curr;
    } //findWinner

    private boolean hasWinner(boolean [] friends) {
        int alive = 0;

        for (boolean friend : friends) {
            if (friend) ++alive;
            if (alive > 1) return false;
        } //for

        return alive == 1;
    } //hasWinner

    private int iter(int curr, int k, boolean [] friends) {
        if (curr == friends.length) return iter(1, k, friends);
        if (!friends[curr]) return iter(curr + 1, k, friends);
        if (k == 0) return curr;
        return iter(curr + 1, k - 1, friends);
    } //iter
} //Sol