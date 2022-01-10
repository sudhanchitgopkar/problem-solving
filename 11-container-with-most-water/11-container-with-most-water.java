class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int lMax = 0, gMax = 0;
        
        while (r > l) {
            lMax = (r-l) * Math.min(height[l],height[r]);
            if (height[r] > height[l]) 
                l++;
            else 
                r--;
            if (lMax > gMax)
                gMax = lMax;
        } //while
        
        return gMax;
    } //maxArea
} //Solution