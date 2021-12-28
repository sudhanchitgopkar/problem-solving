class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap <Integer,Integer> hm = new HashMap <Integer,Integer> ();
        
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i]))
                return true;
            else
                hm.put(nums[i],i);
        } //for
        
        return false;
    } //containsDuplicate
} //Sol