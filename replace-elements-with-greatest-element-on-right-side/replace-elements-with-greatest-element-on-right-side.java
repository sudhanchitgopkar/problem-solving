class Solution {
    public int[] replaceElements(int[] arr) {
        int currMax = arr[arr.length - 1];
        int temp = 0;
        arr[arr.length - 1] = -1;
        
        for (int i = arr.length-2; i >= 0; i--) {
            temp = arr[i];
            arr[i] = currMax;
            
            if (temp > currMax)
                currMax = temp;
        } //for
        
        return arr;
    } //replaceElems
} //Solution