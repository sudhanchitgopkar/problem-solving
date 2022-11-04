class Solution {
    public int longestPalindrome(String[] words) {
        int [][] freq = new int [26][26];
        int size = 0;
        
        for (String word : words) {
            int firstChar = word.charAt(0) - 'a', secondChar = word.charAt(1) - 'a';
            if (freq[secondChar][firstChar] > 0) {
                size += 4;
                freq[secondChar][firstChar]--;
            } else {
                freq[firstChar][secondChar]++;
            } //if
        } //for
        
        
        for (int character = 0; character < 26; character++) {
            if (freq[character][character] > 0) {
                size += 2;
                break; 
            } //if
        } //for
        
        return size;
    } //longestPalindrome
} //Solution