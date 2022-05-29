class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int nlen = numbers.length;
        int l = 0, r = nlen-1;
               
        while (l < r) {
            if (numbers[l] + numbers[r] > target) r--;
            else if (numbers[l] + numbers[r] < target) l++;
            else return new int [] {l+1, r+1};
        } //while
        
        return new int [] {};
    } //twoSumTwo
}  //Solution