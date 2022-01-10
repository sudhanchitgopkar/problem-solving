class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length-1;
        
        while (r > l) {
            if (numbers[l] + numbers[r] == target)
                return new int [] {l+1,r+1};
            else if (numbers[l] + numbers[r] < target)
                l++;
            else
                r--;
        } //while
        
        return new int [] {};
    } //twoSumTwo
}  //Solution