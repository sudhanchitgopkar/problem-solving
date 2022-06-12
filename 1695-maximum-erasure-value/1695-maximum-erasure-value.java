class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int l = 0;
        HashMap <Integer, Integer> seen = new HashMap <Integer,Integer> ();
        int max = 0, score = 0;
        
        for (int r = 0; r < nums.length; r++) {
            if (seen.containsKey(nums[r]) && seen.get(nums[r]) >= l) 
                while (l <= seen.get(nums[r])) 
                    score -= nums[l++];
            
            score += nums[r];
            seen.put(nums[r],r);
            
            if (score > max) max = score;
        } //for
        
        return max;
    } //maxUniqueSubArr
} //Sol