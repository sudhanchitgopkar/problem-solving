class Solution {
    public int maxArea(int[] h) {
        int max = 0, curr = 0;
        int l = 0, r = h.length-1;
        
        while (l < r) {
            curr =  Math.min(h[l],h[r]) * (r-l);
            max = max > curr ? max : curr;        
            if (h[l] < h[r]) l++;
            else r--;
        } //while
       
        return max;
    } // maxArea
} // Problems
