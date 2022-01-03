class Solution {
    public int heightChecker(int[] heights) {
        int [] sorted = new int [heights.length];
        int errors = 0;
        
        for (int i = 0; i < heights.length; i++) 
            sorted[i] = heights[i];
        
        Arrays.sort(sorted);
        
        for (int i = 0; i < heights.length; i++)
            if(sorted[i] != heights[i])
                errors++;
        
        return errors;
    } //heightChecker
} //Solution