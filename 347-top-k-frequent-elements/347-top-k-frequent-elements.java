class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap <Integer, Integer> freq = new HashMap <Integer, Integer> ();
        ArrayList<Integer> [] buckets = new ArrayList [nums.length+1];
        int [] sol = new int [k];
        
        for (int n : nums)
            freq.put(n,freq.getOrDefault(n,0)+1);
        
        for (int val: freq.keySet()) {
            int frequency = freq.get(val);
            if (buckets[frequency] == null) 
                buckets[frequency] = new ArrayList <Integer>();
            buckets[frequency].add(val);
        } //for
        
        int sPtr = 0, bPtr = buckets.length-1;
        while (sPtr < k) {
            if (buckets[bPtr] != null)
                for (int b : buckets[bPtr])
                    sol[sPtr++] = b;
            bPtr--;
        } //while
        
        return sol;
    } //topK
} //Sol