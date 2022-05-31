class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap <Integer, Integer> freq = new HashMap <Integer, Integer> ();
        List<Integer> [] freqArr = new List [nums.length+1];
        int [] sol = new int [k];
        int solptr = 0;
        
        for (int n : nums) {
            if (freq.containsKey(n))
                freq.put(n,freq.get(n) + 1);
            else
                freq.put(n,1);
        } //for
        
        for (int key : freq.keySet()) {
            if (freqArr[freq.get(key)] == null) {
                freqArr[freq.get(key)] = new ArrayList<Integer>();
                freqArr[freq.get(key)].add(key);
            } else {
                freqArr[freq.get(key)].add(key);
            }
        } //for
        
        for (int i = freqArr.length-1; i >= 0 && solptr < k; i--) {
            if (freqArr[i] != null) {
                for (int j = 0; j < freqArr[i].size(); j++) {
                    sol[solptr++] = freqArr[i].get(j);
                } //for
            } //if
        } //for
        
        return sol;
    } //topK
} //Sol