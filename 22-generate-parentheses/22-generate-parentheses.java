class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> sol = new ArrayList<String>();
        backtrack(sol,"",0,0,n);
        return sol;
    } //genParen
    
    public void backtrack(List<String> sol, String s, int open, int close, int max) {
        if (s.length() == max * 2) {
            sol.add(s);
            return;
        } //if  
        if (open < max) backtrack(sol, s + "(", open + 1, close, max);
        if (close < open) backtrack(sol, s + ")", open, close + 1, max);
    } //backtrack
} //Sol