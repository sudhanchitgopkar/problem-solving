class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap <Integer, Integer> diff = new HashMap <> ();
        int sol = 0;
        for (int task : tasks) diff.put(task, diff.getOrDefault(task, 0) + 1);
        
        for (int d : diff.keySet()) {
            int rounds = calcRounds(diff.get(d));
            if (rounds == -1) return -1;
            else sol += rounds;
        } //for

         return sol;
    } //minRounds

    private int calcRounds (int t) {
        if (t == 1) return -1;
        else if (t == 4) return 2;
        else if (t % 3 == 0) return t/3;
        else if (t % 2 == 0 && (t-2) % 3 == 0) return ((t - 2) / 3) + 1;
        else return Math.min(calcRounds(t-3), calcRounds(t-2)) + 1;
    } //calcRounds
} //Sol


