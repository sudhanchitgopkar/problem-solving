class Solution {
    public int majorityElement(int[] nums) {
        HashMap <Integer, Integer> freq = new HashMap <Integer, Integer> ();
        
        for (int n:nums) 
            if (freq.containsKey(n))
                if (freq.get(n)+1 >= nums.length/2+1) return n;
                else freq.put(n, freq.get(n)+1);
            else freq.put(n,1);
        
        return nums[0];
    } //majorityElem
} //Solution