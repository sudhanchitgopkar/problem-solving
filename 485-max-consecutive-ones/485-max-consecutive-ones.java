class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currMax = 0;
        int globalMax = 0;
        
        for (int i:nums) {
            if (i == 1) {
                currMax++;
            } else {
                if (currMax > globalMax) 
                    globalMax = currMax;
                currMax = 0;
            } //if
        } //for
        
        if (currMax > globalMax) 
            globalMax = currMax;
        
        return globalMax;
    } //maxConsecutiveOnes
} //Solution