class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> sol = new LinkedList<>();
        
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int l = i+1, r = nums.length-1, target = 0-nums[i];
                while (r > l) {
                    if (nums[l] + nums[r] > target)
                        r--;
                    else if (nums[l] + nums[r] < target)
                        l++;
                    else {
                        sol.add(Arrays.asList(nums[i],nums[l],nums[r]));
                        while (r > l && nums[l] == nums[l+1])
                            l++;
                         while (r > l && nums[r] == nums[r-1])
                            r--;
                        l++;
                        r--;
                    } //if
                } //while
            } //if
        } //for
        
        return sol;
    } //threeSum
} //Solution