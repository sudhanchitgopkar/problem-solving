class Solution {
    public boolean backspaceCompare(String s, String t) {
        if (s.equals(t)) return true;
        Stack <Character> ss = new Stack <> (), st = new Stack <> ();

        for (char c : s.toCharArray()) {
            if (c == '#' && !ss.isEmpty()) ss.pop();
            else if (c != '#') ss.push(c); 
        } //for

        for (char c : t.toCharArray()) {
            if (c == '#' && !st.isEmpty()) st.pop();
            else if (c != '#') st.push(c); 
        } //for

        if (ss.size() != st.size()) return false;

        while (!ss.isEmpty()) {
            if (ss.pop() != st.pop()) return false;
        } //while

        return true;
    } //backCompare
} //Sol