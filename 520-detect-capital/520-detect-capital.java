class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.toUpperCase().equals(word) 
            || word.toLowerCase().equals(word)
            || word.substring(1,word.length()).toLowerCase()
            .equals(word.substring(1,word.length())))
            return true;     
        return false;
    } //detectCap
} //Solution