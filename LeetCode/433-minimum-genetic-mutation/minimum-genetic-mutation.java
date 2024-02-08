class Solution {
    public int minMutation(String startGene, String endGene, String[] bankList) {
        int numSteps = 0;
        HashSet <String> bank = new HashSet <> ();
        HashSet <String> seen = new HashSet <> ();
        Queue <String> q = new LinkedList <> ();
        for (String valid : bankList) bank.add(valid);

        if (!bank.contains(endGene)) return -1;
        q.offer(startGene);
        seen.add(startGene);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(endGene)) return numSteps;

                List<String> next = next(curr, bank);
                for (String s : next) {
                    if (!seen.contains(s)) {
                        q.offer(s);
                        seen.add(s);
                    } //if
                } //for
            } //for
            numSteps++;
        } //while

        return -1;
    } //minMutation


    private List<String> next(String curr, HashSet <String> valid) {
        int n = curr.length();
        List<String> nextSols = new ArrayList <> ();
        char [] poss = new char [] {'A', 'C', 'G', 'T'};

        for (int i = 0; i < n; i++) {
            String pre = curr.substring(0, i);
            String post = curr.substring(i + 1);

            for (char c : poss) {
                if (curr.charAt(i) != c) {
                    String next = pre + c + post;
                    if (valid.contains(next)) nextSols.add(next);
                } //if
            } //for
        } //for

        return nextSols;
    }  //next
} //Class