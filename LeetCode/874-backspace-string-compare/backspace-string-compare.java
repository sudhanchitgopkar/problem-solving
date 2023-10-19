class Solution {
    public boolean backspaceCompare(String s, String t) {
        //if (s.equals(t)) return true;
        Stack <Character> ss = new Stack <> (), st = new Stack <> ();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '#' && !ss.isEmpty()) ss.pop();
            else if (c != '#') ss.push(c); 
        } //for

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
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