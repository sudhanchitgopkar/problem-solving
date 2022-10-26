class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map <Integer, Integer> seenMods = new HashMap <> ();
        int [] sum = new int [nums.length];
        seenMods.put(0,-1);
        sum[0] = nums[0];
        if (sum[0]%k != 0) seenMods.put(sum[0]%k,0);
        
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i-1];
            if (i - seenMods.getOrDefault(sum[i] % k,i) >= 2) 
                return true;
            else if (!seenMods.containsKey(sum[i] % k))
                seenMods.put(sum[i] % k,i);
        } //for
        
        return false;
    }
}