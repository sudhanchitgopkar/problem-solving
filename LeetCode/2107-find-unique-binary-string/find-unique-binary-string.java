class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> has = new HashSet <> ();

        for (String num : nums) {
            has.add(strToI(num));
        } //for
        
        for (int i = 0; i < Math.pow(2, nums.length) - 1; i++) {
            if (!has.contains(i)) {
                String sol = Integer.toBinaryString(i);
                while (sol.length() != nums.length) sol = '0' + sol;
                return sol;
            } //if
        } //for

        return "1"; //unreachable
    } //findDiff

    private int strToI(String s) {
        int irep = 0, pow = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            irep += (s.charAt(i) == '1' ? 1 : 0) * pow;
            pow *= 2;
        } //for

        return irep;
    } //strToI
} //Sol