class Solution {
    public int[] twoSum(int[] n, int t) {
        HashMap <Integer, Integer> h = new HashMap <Integer, Integer> ();
        
        for (int i = 0; i < n.length; i++)
            if (h.containsKey(t-n[i])) return new int [] {i,h.get(t-n[i])};
            else h.put(n[i],i);
        
        return new int [] {};
    } //nums
} //solution