class Solution {
    public int minOperations(String[] logs) {
        return solve(logs, 0, 0);
    } //minOps

    private int solve(String [] logs, int i, int depth) {
        if (i == logs.length) return depth;
        if (logs[i].equals("../")) return solve(logs, i + 1, depth == 0 ? 0 : depth - 1);
        if (logs[i].equals("./")) return solve(logs, i + 1, depth);
        return solve(logs, i + 1, depth + 1);
    } //solve
} //Sol