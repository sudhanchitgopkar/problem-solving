class Solution {
    HashSet <String> dict;
    public String replaceWords(List<String> dictionary, String sentence) {
        dict = new HashSet<> (dictionary);
        String sol = "";

        for (String word : sentence.split(" ")) {
            sol += evalWord(word) + " ";
        } //for
        
        return sol.substring(0, sol.length() - 1);
    } //replace

    private String evalWord(String word) {
        for (int i = 0; i < word.length(); i++) {
            String substr = word.substring(0, i + 1);
            if (dict.contains(substr)) return substr;
        } //for
        return word;
    } //evalWord
} //Sol