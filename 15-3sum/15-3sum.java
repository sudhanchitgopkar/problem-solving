class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<List<Integer>> ();
        
        for (int i = 0; i < nums.length-1; i++) {
            if (i == 0 || nums[i-1] != nums[i]) {
               int l = i+1, r = nums.length-1;
                while (l < r) {
                    if (nums[l] + nums[r] + nums[i] < 0) {
                        l++;
                    } else if (nums[l] + nums[r] + nums[i] > 0) { 
                        r--;
                    } else {
                        ArrayList<Integer> temp = new ArrayList<Integer> ();
                        temp.add(nums[l++]); 
                        temp.add(nums[r--]); 
                        temp.add(nums[i]);
                        
                        sol.add(temp);
                        
                        while (r > l && nums[r] == nums[r+1]) r--;
                        while (r > l && nums[l] == nums[l-1]) l++;
                    } //if
                } //while
            } //if    
        } //for
        
        return sol;
    } //threeSum
} //Solution