class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet <Integer> f = new HashSet <Integer> ();
        
        for (int i = 0; i < nums.length; i++)
            if (f.contains(nums[i])) return true;
            else f.add(nums[i]);
        
        return false;
    } //containsDuplicate
} //Solution