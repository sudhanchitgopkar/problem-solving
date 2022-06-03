class Solution {
    public int majorityElement(int[] nums) {
        HashMap <Integer, Integer> h = new HashMap <Integer, Integer> ();
        
        for (int n : nums) {
            h.put(n,h.getOrDefault(n,0)+1);
            if (h.get(n) > nums.length/2) return n;
        } //for
        
        return -1; //unreachable!
    } //majorityElem
} //Solution