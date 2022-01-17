class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int [] appeared = new int [nums.length+1];
        List <Integer> sol = new ArrayList <Integer> ();
        for (int n : nums)
            appeared[n]++;
        
        for (int i = 1; i < appeared.length; i++) 
            if (appeared[i] == 0) sol.add(i);

        return sol;
    } //findDisappeared
} //Solution