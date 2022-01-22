class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet <Integer> h = new HashSet <Integer> ();
        for (int n : nums)
            if (h.contains(n)) return true;
            else h.add(n);
        return false;
    } //containsDuplicate
} //Solution