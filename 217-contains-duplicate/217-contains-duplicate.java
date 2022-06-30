class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet h = new HashSet <Integer> ();
        
        for (int num : nums)
            if (h.contains(num)) 
                return true;
            else
                h.add(num);
        
        return false;
    } //containsDup
} //Sol
