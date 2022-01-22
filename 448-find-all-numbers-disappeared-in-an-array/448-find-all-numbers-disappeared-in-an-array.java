class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int [] f = new int [nums.length+1];
        List <Integer> sol = new ArrayList <Integer>();
        for (int n : nums)
            f[n]++;

        for (int i = 1; i < f.length; i++)
            if (f[i] == 0) sol.add(i);
        
        return sol;
    } //findDisappeared
} //Solution