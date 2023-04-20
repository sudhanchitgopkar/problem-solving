class Solution {
    int n;
    List <String> sol = new ArrayList <> ();
    public List<String> generateParenthesis(int n) {
        this.n = n;
        backtrack(0, 0, "");
        return sol;
    } //genParen
    
    private void backtrack(int open, int close, String curr) {
        if (open == n && close == n) {
            sol.add(curr);
        } else if (open == n) {
            backtrack(open, close + 1, curr + ")");
        } else if (open <= close) {
            backtrack(open + 1, close, curr + "(");
        } else {
            backtrack(open + 1, close, curr + "(");
            backtrack(open, close + 1, curr + ")");
        } //if
    } //backtrack
} //Sol