class Solution {
    public boolean arrayStringsAreEqual(String[] x, String[] y) {
        int xi= 0, xc = 0, yi = 0, yc = 0;
        
        while (xi < x.length && yi < y.length) {
            if (x[xi].charAt(xc) != y[yi].charAt(yc)) return false;
            xc = xc + 1 >= x[xi].length() ? xc = 0 : xc + 1;
            yc = yc + 1 >= y[yi].length() ? yc = 0 : yc + 1;
            xi = xc == 0 ? xi + 1 : xi;
            yi = yc == 0 ? yi + 1 : yi;
        } //while
        
        return xi == x.length && yi == y.length;
    }
}