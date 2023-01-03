class Solution {
    public int minDeletionSize(String[] strs) {
        int del = 0;
        
        for (int i = 0; i < strs[0].length(); i++) {
            char prev = strs[0].charAt(i);
            for (String s : strs) {
                if (s.charAt(i) < prev) {
                    del++;
                    break;
                } else {
                    prev = s.charAt(i);
                } //if
            } //for
        } //for
        
        return del;
    } //minDeletion
} //Sol