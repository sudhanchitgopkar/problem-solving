class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int [] a = new int [nums.length+1];
        List <Integer> sol = new ArrayList <Integer> ();
        
        for (int n : nums)
            a[n]++;
        
        for (int i = 1; i < a.length; i++) 
            if (a[i] == 0) sol.add(i);

        return sol;
    } //findDisappeared
} //Solution