class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> sol = new ArrayList <> ();
        HashMap <Integer, Integer> freq = new HashMap <> ();

        for (int num : nums) {
            if (freq.getOrDefault(num, 0) + 1 > n/3) {
                sol.add(num);
                freq.put(num, -5001);
            } else {
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            } //if
        } //for

        return sol;
    } //majority
} //Sol