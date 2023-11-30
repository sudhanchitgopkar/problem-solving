class Solution {
    public String longestWord(String[] words) {
        String sol = "";
        HashMap <Integer, Set<String>> byLen = new HashMap <> ();

        for (String word : words) {
            if (!byLen.containsKey(word.length())) {
                byLen.put(word.length(), new HashSet<String> ());
            } //if
            byLen.get(word.length()).add(word);
        } //for

        for (String s : (byLen.containsKey(1) ? byLen.get(1) : new ArrayList <String> ())) {
            String candidate = dfs(s, byLen);
            sol = candidate.length() > sol.length() ? candidate 
                : candidate.length() == sol.length() && sol.compareTo(candidate) > 0 ? candidate 
                : sol;
        } //for

        return sol;
    } //longestWord

    private String dfs(String s, HashMap <Integer, Set<String>> byLen) {
        int n = s.length();
        if (!byLen.containsKey(n + 1)) return s;

        String sol = s;
        for (String next : byLen.get(n + 1)) {
            if (next.substring(0, next.length() - 1).equals(s)) {
                String candidate = dfs(next, byLen);
                sol = candidate.length() > sol.length() ? candidate 
                : candidate.length() == sol.length() && sol.compareTo(candidate) > 0 ? candidate 
                : sol;
            } //for
        } //for

        return sol;
    } //private
} //Sol