class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> manages = new ArrayList<>();

        for (int i = 0; i < manager.length; i++) {
            manages.add(0, new ArrayList<>());
        } // for

        for (int i = 0; i < manager.length; i++) {
            if(manager[i] != -1) {
                manages.get(manager[i]).add(i);
            } // if
        } // for

        return dfs(headID, manages, informTime);
    } // numOfMinutes

    public int dfs(int empID, List<List<Integer>> manages, int[] informTime) {
        int sol = 0;
        if (informTime[empID] == 0) {
            return 0;
        } // if
        for (int subID: manages.get(empID)) {
            int empSol = dfs(subID, manages, informTime);
            if (empSol > sol) {
                sol = empSol;
            } // if
        } // for
        return informTime[empID] + sol;
    } // dfs
} // Solution