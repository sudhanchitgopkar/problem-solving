class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;

        for (String log : logs) {
            if (log.equals("../")) depth = Math.max(depth - 1, 0);
            else if (!log.equals("./")) ++depth;
        } //for

        return depth;
    } //minOps
} //Sol