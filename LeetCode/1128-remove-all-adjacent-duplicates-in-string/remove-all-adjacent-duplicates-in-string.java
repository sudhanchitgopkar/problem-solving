class Solution {
    public String removeDuplicates(String s) {
        Stack <Character> st = new Stack <> ();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == c) st.pop();
            else st.push(c);
        } //for

        while (!st.isEmpty()) sb.insert(0, st.pop());
        return sb.toString();
    } //removeDups
} //Sol