class Solution {
    public int vowelStrings(String[] words, int l, int r) {
        int sol = 0;
        for (int i = l; i <= r; i++) sol += is(words[i]);
        return sol;
    } //vowelStrings

    private int is(String s) {
        HashSet <Character> h = new HashSet <Character> ();
        h.add('a');
        h.add('e');
        h.add('i');
        h.add('o');
        h.add('u');

        return h.contains(s.charAt(0)) && h.contains(s.charAt(s.length() - 1)) ? 1 : 0;
    } //is
} //Sol