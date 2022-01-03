class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int n1ptr = m-1;
        int n2ptr = n-1;
        int curr = nums1.length-1;
        
        while (n1ptr >= 0 && n2ptr >= 0) {
            if (nums1[n1ptr] > nums2[n2ptr]) {
                nums1[curr--] = nums1[n1ptr--];
            } else {
                nums1[curr--] = nums2[n2ptr--];
            } //if
        } //while
        
        if (n1ptr == -1)
            while (curr >= 0)
                nums1[curr--] = nums2[n2ptr--];
                
    } //merge
} //Solution