class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int n1ptr = m - 1, n2ptr = n - 1;
        
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (n2ptr < 0) 
                return;
            else if (n1ptr < 0) 
                nums1[i] = nums2[n2ptr--];
            else if (nums1[n1ptr] > nums2[n2ptr])
                nums1[i] = nums1[n1ptr--];
            else
                nums1[i] = nums2[n2ptr--];
        } //for
            
        return;
    } //merge
} //Solution