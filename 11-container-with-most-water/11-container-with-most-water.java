class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int hlen = height.length;
        int lMax = Math.min(height[l],height[r]) * (r-l), gMax = lMax;
        
        while (l < r) {
            if (height[l] < height[r]) l++;
            else r--;
            lMax = Math.min(height[l],height[r]) * (r-l);
            if (lMax > gMax) gMax = lMax;
        } //while
        
        return gMax;
    } //maxArea
} //Solution