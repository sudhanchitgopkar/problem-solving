class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet <Integer> h = new HashSet <Integer> ();
        
        for (int n : nums) {
            if (h.contains(n)) return true;
            else h.add(n);
        } //for
        
        return false;
    } //containsDup
} //Sol

/*
Time: O(n)
Space: O(n)
*/