class Solution {
    List<List<Integer>> coordSet = new ArrayList<List<Integer>>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (checkAtlantic(heights,i,j,new boolean [heights.length][heights[0].length])
                    && checkPacific(heights,i,j,new boolean [heights.length][heights[0].length])) {
                    ArrayList<Integer> coords = new ArrayList <Integer> ();
                    coords.add(i); coords.add(j);
                    coordSet.add(coords);
                } //if
            } //for
        } //for
        
        return coordSet;
    } //pacificAtlantic
    
    private boolean checkAtlantic (int [][] heights, int row, int col, boolean [][] seen) {
        if (col == heights[0].length-1 || row == heights.length-1) return true;
        
        int currHeight = heights[row][col];
        seen[row][col] = true;
        
        boolean isValid = false;
        
        if (row-1 >= 0 && heights[row-1][col] <= currHeight && !seen[row-1][col]) 
            isValid = isValid || checkAtlantic(heights,row-1,col,seen);
        if (row+1 < heights.length && heights[row+1][col] <= currHeight && !seen[row+1][col]) 
            isValid = isValid || checkAtlantic(heights,row+1,col,seen);
        if (col-1 >= 0 && heights[row][col-1] <= currHeight  && !seen[row][col-1]) 
            isValid = isValid || checkAtlantic(heights,row,col-1,seen);
        if (col+1 < heights[0].length && heights[row][col+1] <= currHeight && !seen[row][col+1]) 
            isValid = isValid || checkAtlantic(heights,row,col+1,seen);
        
        return isValid;    
    } //checkAtlantic
    
    private boolean checkPacific (int [][] heights, int row, int col, boolean [][] seen) {
        if (col == 0 || row == 0) return true;
        
        int currHeight = heights[row][col];
        seen[row][col] = true;
        
        boolean isValid = false;
        
        if (row-1 >= 0 && heights[row-1][col] <= currHeight && !seen[row-1][col]) 
            isValid =  isValid || checkPacific(heights,row-1,col,seen);
        if (row+1 < heights.length && heights[row+1][col] <= currHeight && !seen[row+1][col]) 
            isValid =  isValid || checkPacific(heights,row+1,col,seen);
        if (col-1 >= 0 && heights[row][col-1] <= currHeight  && !seen[row][col-1]) 
            isValid =  isValid || checkPacific(heights,row,col-1,seen);
        if (col+1 < heights[0].length && heights[row][col+1] <= currHeight && !seen[row][col+1]) 
            isValid =  isValid || checkPacific(heights,row,col+1,seen);
        
        return isValid;    
    } //checkPacific
} //Sol