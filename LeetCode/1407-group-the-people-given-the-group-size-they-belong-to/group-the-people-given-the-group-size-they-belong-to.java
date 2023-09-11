class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap <Integer, List<Integer>> groups = new HashMap <> ();
        List<List<Integer>> sol = new ArrayList <> ();

        for (int i = 0; i < groupSizes.length; i++) {
            if (!groups.containsKey(groupSizes[i])) {
                groups.put(groupSizes[i], new ArrayList <Integer> ());
            } //if
            groups.get(groupSizes[i]).add(i);
        } //for

        for (int size : groups.keySet()) {
            List<Integer> res = new ArrayList <> ();
            for (int i = 0; i < groups.get(size).size(); i++) {
                res.add(groups.get(size).get(i));
                if (res.size() == size) {
                    sol.add(res);
                    res = new ArrayList <> ();
                } //if
            } //for
        } //for

        return sol;
    } //groupThePeople
} //Sol