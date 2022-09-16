class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3 || arr[1] <= arr[0]) return false;
        boolean isDec = false;
        
        for (int i = 1; i < arr.length-1; i++) {
            if (!isDec && arr[i] < arr[i+1]) continue;
            else if (!isDec) isDec = true;
            else if (isDec && arr[i] > arr[i+1]) continue;
            else return false;
        }
        
        return arr[arr.length-1] < arr[arr.length-2];
    } //validMountain
} //solution

/*
int l = 0, r = arr.length-1;
        
        while (l+1 < arr.length-1 && arr[l] < arr[l+1]) l++;
        while (r-1 > -1 && arr[r] < arr[r-1]) r--;
        
        return l == r && r != 0 && r < arr.length-1;       
*/