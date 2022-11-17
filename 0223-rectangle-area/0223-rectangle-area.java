class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        
        int rectA = Math.abs(ax2 - ax1) * Math.abs(ay2 - ay1);
        int rectB = Math.abs(bx2 - bx1) * Math.abs(by2 - by1);
        int xOverlap = 0, yOverlap = 0;
        
        if (bx1 >= ax1 && bx1 <= ax2) xOverlap = Math.min(bx2,ax2) - Math.max(bx1,ax1);
        else if (ax1 >= bx1 && ax1 <= bx2) xOverlap = Math.min(bx2,ax2) - Math.max(bx1,ax1);
        
        if (by1 >= ay1 && by1 <= ay2) yOverlap = Math.min(by2,ay2) - Math.max(by1,ay1);
        else if (ay1 >= by1 && ay1 <= by2) yOverlap = Math.min(by2,ay2) - Math.max(by1,ay1);
        return rectA + rectB - (xOverlap * yOverlap);
    }
}