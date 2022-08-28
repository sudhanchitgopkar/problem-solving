class Solution {
    public void merge(int[] n1, int k1, int[] n2, int k2) {   
        int n1ptr = k1-1, n2ptr = k2-1, i = n1.length-1;
        
        while (n1ptr >= 0 && n2ptr >= 0) 
            if (n1[n1ptr] >= n2[n2ptr]) n1[i--] = n1[n1ptr--];
            else n1[i--] = n2[n2ptr--];
        
        while (n2ptr >= 0) n1[i--] = n2[n2ptr--];
    } //merge
} //Solution