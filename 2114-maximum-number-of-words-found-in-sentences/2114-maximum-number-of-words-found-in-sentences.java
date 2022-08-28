class Solution {
    public int mostWordsFound(String[] sentences) {
        int maxWords = 0;
        
        for (String sentence : sentences) {
            int currWords = 1;
            for (char c : sentence.toCharArray()) if (c == ' ') currWords++;
            maxWords = maxWords < currWords ? currWords : maxWords;
        } //for
        
        return maxWords;
    }
}