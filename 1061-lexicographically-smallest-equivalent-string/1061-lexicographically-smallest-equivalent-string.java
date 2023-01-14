class Solution {
    public String smallestEquivalentString(String s1, String s2, String base) {
        StringBuilder sol = new StringBuilder();
        int [] parent = new int [26];
        for (int i = 0; i < parent.length; i++) parent[i] = i;

        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i), c2 = s2.charAt(i);
            char m1 = getMin(c1, parent), m2 = getMin(c2, parent);
            if (m1 <= m2) parent[m2-'a'] = m1-'a';
            else parent[m1-'a'] = m2-'a';
        } //for

        for (char c : base.toCharArray()) sol.append(getMin(c, parent));
        return sol.toString();
    } //smallestEquiv

    private char getMin(char curr, int [] parent) {
        if (parent[curr-'a'] == curr-'a') return curr;
        return getMin((char)(parent[curr-'a'] + 97), parent);
    } //getMin
} //Sol