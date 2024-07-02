class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int [] freq1 = new int [1001], freq2 = new int [1001];
        ArrayList <Integer> inter = new ArrayList <> ();
        
        for (int val : nums1) {
            freq1[val]++;
        } //for

        for (int val : nums2) {
            freq2[val]++;
        } //for
        
        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j < Math.min(freq1[i], freq2[i]); j++) {
                inter.add(i);
            } //for
        } //for

        return inter.stream().mapToInt(Integer::intValue).toArray();
    } //intersect
} //Sol