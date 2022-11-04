class Solution {
    public int longestPalindrome(String[] words) {
        HashMap <String, Integer> freq = new HashMap <> ();
        int size = 0;
        
        for (String word : words) {
            String inverse = word.charAt(1) + "" + word.charAt(0);
            if (freq.containsKey(inverse) && freq.get(inverse) > 0) {
                size += 4;
                freq.put(inverse, freq.get(inverse) - 1);
            } else {
                freq.put(word,freq.getOrDefault(word,0) + 1);
            }
        } //for
        
        for (String key : freq.keySet()) {
            if (key.charAt(0) == key.charAt(1) && freq.get(key) == 1) {
                size +=2;
                break;
            } //if
        } //for
        
        return size;
    } //longestPalindrome
} //Solution