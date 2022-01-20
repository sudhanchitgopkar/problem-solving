class Solution {
    public boolean validMountainArray(int[] arr) { 
        if (arr.length < 3) return false;
        
        int l = 0, r = arr.length-1;
        
        while (arr[l] < arr[l+1])
            if (++l == arr.length-1) return false;
        
        while (arr[r] < arr[r-1])
            if(--r == 0) return false;
        
        if (l == r) return true;
        return false;
        
    } //validMountain
} //solution