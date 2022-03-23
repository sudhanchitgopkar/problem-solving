class Solution {
    public List<List<Integer>> generate(int numRows) {
       List<List<Integer>> sol = new ArrayList<List<Integer>>();
        
        sol.add(Arrays.asList(1));
        if (numRows == 1) return sol;
        
        sol.add(Arrays.asList(1,1));
        if (numRows == 2) return sol;
        
        ArrayList<Integer> temp;
        for (int i = 3; i <= numRows; i++) {
            temp = new ArrayList<Integer>();
            int l = 0, r = 1, p = 1;
            temp.add(1);
            while (r < i-1) {
               temp.add(sol.get(i-2).get(l) + sol.get(i-2).get(r));
                l++;
                r++;
                p++;
            } //while
            temp.add(1);
            sol.add(temp);
        } //for
        
        return sol;
    } //gen
} //Sol