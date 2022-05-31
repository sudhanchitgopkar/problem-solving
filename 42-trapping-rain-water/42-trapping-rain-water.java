class Solution {
    public int trap(int[] height) {
        if (height.length < 3) return 0;
        
        int l = 0, r = height.length-1;
        int lMax = l, rMax = r;
        int trapped = 0;
        
        //while (height[l] <= height[l+1]) l++;
        //while (height[r] <= height[r-1]) r--;
        
        while (l < r) {
            if (height[lMax] < height[rMax]) {
                if (height[l] > height[lMax]) lMax = l;
                else trapped += height[lMax] - height[l++];
            } else {
                if (height[r] > height[rMax]) rMax = r;
                else trapped += height[rMax] - height[r--];
            }
        } //while
        
        return trapped;
    } //trap
} //Sol