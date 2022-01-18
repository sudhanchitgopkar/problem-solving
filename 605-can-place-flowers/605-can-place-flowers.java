class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1)
            if (flowerbed[0] == 1 && n > 0) return false;
            else if (n > 1) return false;
            else return true;
        
        for (int i = 1; i < flowerbed.length; i++) {
            if (i == 1 && flowerbed[i] == 0 && flowerbed[i-1] == 0) {
                flowerbed[i-1] = 1; n--;
            } else if (flowerbed[i-1] == 0 && flowerbed[i] == 0) {
                flowerbed[i] = 1; n--;
            } else if (flowerbed[i-1] == 1 && flowerbed[i] == 1) {
                flowerbed[i-1] = 0; n++;
            } //if
        } //for
        
        if (n > 0)
            return false;
        else
            return true;

    } //canPlaceFlowers
} //Solution