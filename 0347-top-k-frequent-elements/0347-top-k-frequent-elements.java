class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map <Integer, Integer> freq = new HashMap <Integer, Integer> ();
        List<List<Integer>> buckets = new ArrayList<List<Integer>> ();
        int [] sol = new int [k];
        int soli = 0;
        
        //created freq map
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num,0)+1);
        }
        
        //created our buckets
        for (int i = 0; i <= nums.length; i++) {
            buckets.add(new ArrayList<Integer> ());
        }
        
        //populate buckets
        for (int elem : freq.keySet()) {
            int frequency = freq.get(elem);
            buckets.get(frequency).add(elem);
        }
        
        for (int i = buckets.size()-1; i >= 0; i--) {
            for (int elem : buckets.get(i)) {
                sol[soli] = elem;
                soli++;
                if (soli == k) break;
            } //for
            if (soli == k) break;
        } //for
        
        return sol;
    } //topK
} //Sol