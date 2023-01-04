class Solution {
    public int minimumRounds(int[] tasks) {
        HashMap <Integer, Integer> diff = new HashMap <> ();
        int sol = 0;
        for (int task : tasks) diff.put(task, diff.getOrDefault(task, 0) + 1);
        
        for (int d : diff.keySet()) 
            if (diff.get(d) == 1) return -1;
            else sol += diff.get(d) % 3 == 0 ? diff.get(d)/3 : diff.get(d)/3 + 1;
        

         return sol;
    } //minRounds
} //Sol