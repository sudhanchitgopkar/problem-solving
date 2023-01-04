class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap <Integer, Integer> diff = new HashMap <> ();
        int sol = 0;
        for (int task : tasks) diff.put(task, diff.getOrDefault(task, 0) + 1);
        
        for (int d : diff.keySet()) {
            int val = diff.get(d);
            if (val == 1) return -1;
            sol += val/3;
            if (val % 3 != 0) sol++;
        } //for
             

         return sol;
    } //minRounds
} //Sol