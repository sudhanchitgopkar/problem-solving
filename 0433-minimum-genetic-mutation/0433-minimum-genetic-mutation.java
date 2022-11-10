class Solution {
    public int minMutation(String start, String end, String[] bank) {
        if (start.equals(end)) return 0;
        Queue <String> q = new LinkedList <String> ();
        HashSet <String> seen = new HashSet <String> ();
        int numMutations = 1;
        
        q.offer(start);
        seen.add(start);
        
        while (!q.isEmpty()) {
            int qSize = q.size();
            
            for (int i = 0; i < qSize; i++) {
                String curr = q.poll();
                for (String s : bank) {
                    if (!seen.contains(s) && isOneOff(curr, s)) {
                        if (s.equals(end)) return numMutations;
                        else q.offer(s);
                        seen.add(s);
                    } //if
                } //for
            } //for
            numMutations++;
        } //while
        
        return -1;
    } //minMutations
    
    private boolean isOneOff(String a, String b) {
        int numDiffs = 0;
        for (int i = 0; i < 8; i++) {
            if (a.charAt(i) != b.charAt(i)) numDiffs++;
            if (numDiffs > 1) return false;
        } //for
        
        return numDiffs == 1;
    } //isOneOff
} //Solution