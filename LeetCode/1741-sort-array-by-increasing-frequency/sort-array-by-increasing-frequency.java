class Solution {
    public int[] frequencySort(int[] nums) {
        int soli = 0;
        List<List<Integer>> buckets = new ArrayList <> ();
        HashMap <Integer, Integer> freq = new HashMap <> ();
        int [] sol = new int [nums.length];

        //populate freq map
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        } //for

        //init buckets
        for (int i = 0; i < 201; i++) {
            buckets.add(new ArrayList <Integer> ());
        } //for

        //populate buckets
        for (int num : freq.keySet()) {
            buckets.get(freq.get(num)).add(num);
        } //for
        
        for (int i = 0; i < buckets.size(); i++) {
            if (buckets.get(i).size() == 0) continue;
            Collections.sort(buckets.get(i));
            for (int j = buckets.get(i).size() - 1; j >= 0; j--) {
                for (int k = 0; k < freq.get(buckets.get(i).get(j)); k++) {
                    sol[soli++] = buckets.get(i).get(j);
                } //for
            } //for
        } //for

        return sol;
    } //freqSort
} //Sol
