class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer, Integer> freq = new HashMap <Integer, Integer> ();
        List<Integer> [] buckets = new List[nums.length + 1];
        int [] sol = new int [k];
        
        //make frequency table
        for (int n : nums)
            freq.put(n,freq.getOrDefault(n,0)+1);
        
        //put freq in buckets
        for (int key : freq.keySet()) {
            int val = freq.get(key);
            if (buckets[val] == null)
               buckets[val] = new ArrayList<Integer>();
            buckets[val].add(key);
        } //for
        
        int bucketPtr = buckets.length - 1;
        int solPtr = 0;
        while (solPtr < k) {
            while (buckets[bucketPtr] == null) bucketPtr--;
            for (int n : buckets[bucketPtr])
                sol[solPtr++] = n;
            bucketPtr--;
        } //while
    
        return sol;
    } //topK
} //Sol