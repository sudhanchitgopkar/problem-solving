class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap <Integer, Integer> h = new HashMap <Integer, Integer> ();
        
        for (int i = 0; i < nums.length; i++)
            if (h.containsKey(nums[i]))
                if (Math.abs(h.get(nums[i]) - i) <= k) return true;
                else h.put(nums[i],i);
            else h.put(nums[i],i);
        
        return false;
    } //containsNearbyDuplicate
} //Solution