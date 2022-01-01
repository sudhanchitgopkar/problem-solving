class Solution {
    public int findNumbers(int[] nums) {
        int numEven = 0;
        
        for (int i : nums) {
            int mod = 10;
            int count = 0;
            while (i % mod != i) {
                mod *= 10;
                count++;
            } //while
            if (count % 2 == 1)
                numEven++;
        } //for
        
        return numEven;
    } //findNumbers
} //Solution