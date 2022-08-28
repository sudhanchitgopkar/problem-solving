class Solution {
    public int removeDuplicates(int[] n) {
        int dup = 1;
        
        for (int i = 1; i < n.length; i++) {
            if (n[i] != n[i-1]) n[dup++] = n[i];
        } //for
       
        return dup;
    } //removeDuplicates
} //Solution


// 1 1 2