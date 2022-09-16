class Solution {
    public int longestMountain(int[] arr) {
        int maxLen = 0;
        int l = 0, r = 0;
        boolean asc = false, desc = false;
        
        while (r+1 < arr.length-1) {
            //ascending
            while (r+1 < arr.length && arr[r+1] > arr[r]) {
                r++;
                asc = true;
                
            } 
            //check for plateau
            while (r + 1 < arr.length && arr[r+1] == arr[r]) {
                asc = false;
                r++;
            }
            //descending
            while (r+1 < arr.length && arr[r+1] < arr[r]) {
                r++;
                desc = true;
            }
            int currLen = r - l + 1;
            if (asc && desc && currLen > maxLen) {
                maxLen = currLen;
            }
            
            l = r;
            asc = false;
            desc = false;
        }
        
        return maxLen;
    } //longestMountain
} //Solution