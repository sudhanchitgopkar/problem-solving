class Solution {
    public String makeGood(String s) {        
        Stack <Character> st = new Stack <Character> ();
        StringBuilder sb = new StringBuilder();
        st.push(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            char curr = s.charAt(i), prev = st.isEmpty() ? '1' : st.peek();
            if (st.isEmpty()) {
                st.push(curr);
            } else if (Character.isLetter(curr) && Character.isLetter(prev) &&
                Character.isUpperCase(curr) != Character.isUpperCase(prev) &&
                Character.toUpperCase(curr) == Character.toUpperCase(prev)) {
                st.pop();
            } else {
                st.push(s.charAt(i));
            } //if
        } //for
        
        while(!st.isEmpty()) sb.insert(0,st.pop());
        return sb.toString();
    } //makeGood
} //Solution