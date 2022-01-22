class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int [] f = new int [nums.length];
        List <Integer> sol = new ArrayList <Integer>();
        for (int n : nums)
            f[n-1]++;

        for (int i = 0; i < f.length; i++)
            if (f[i] == 0) sol.add(i+1);
        
        return sol;
    } //findDisappeared
} //Solution