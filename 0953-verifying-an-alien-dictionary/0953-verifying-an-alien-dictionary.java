class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int [] lex = new int [26];

        for (int i = 0; i < 26; i++) 
            lex[order.charAt(i)-'a'] =  i;
        
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i], next = words[i+1];

            if (curr.length() > next.length() && 
                curr.substring(0,next.length()).equals(next)) return false;

            for (int j = 0; j < Math.min(curr.length(), next.length()); j++)
                if (lex[curr.charAt(j)-'a'] > lex[next.charAt(j)-'a']) return false;
                else if (lex[curr.charAt(j)-'a'] < lex[next.charAt(j)-'a']) break;
        } //for
        
        return true;
    } //isAlienSorted
} //Sol