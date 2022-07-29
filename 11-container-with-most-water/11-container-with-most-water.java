class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int lMax = 0, gMax = 0;
        
        while (l < r) {
            lMax = (r - l) * Math.min(height[l],height[r]);
            if (height[l] < height[r]) l++;
            else r--;
            gMax = Math.max(lMax, gMax);
        } //while
        
        return gMax;
    } //maxArea
    
} //Solution