class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int n = word.length(), l = word.indexOf(ch), r = l + 1;

        if (l == -1) return word;
        while (l >= 0) sb.append(word.charAt(l--));
        while(r < n) sb.append(word.charAt(r++));
        return sb.toString();
    } //revPre
} //Sol