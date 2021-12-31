class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap <Integer, Integer> freq = new HashMap <Integer, Integer> ();
        ArrayList <Integer> intersection = new ArrayList <Integer> ();
        int [] sol;
        
        for (int i = 0; i < nums1.length; i++) {
            if (freq.containsKey(nums1[i])) 
                freq.put(nums1[i], freq.get(nums1[i]) + 1);
            else
                freq.put(nums1[i], 1);
        } //for
        
        for (int i = 0; i < nums2.length; i++) {
            if (freq.containsKey(nums2[i]) && freq.get(nums2[i]) > 0) {
                intersection.add(nums2[i]);
                freq.put(nums2[i], freq.get(nums2[i]) - 1);
            }
        } //for
        
        sol = new int [intersection.size()];
        for (int i = 0; i < intersection.size(); i++) {
            sol[i] = intersection.get(i);
        }
        
        return sol;
        
    } //intersect
} //Solution