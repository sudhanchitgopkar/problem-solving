class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet <Integer> h = new HashSet <Integer>();
        
        for (int n : nums) {
            if (h.contains(n)) return true;
            h.add(n);
        } //for
        
        return false;
    } //containsDuplicate
} //Solution