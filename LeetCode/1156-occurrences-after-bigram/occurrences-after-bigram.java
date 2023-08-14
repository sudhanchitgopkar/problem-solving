class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String [] words = text.split(" ");
        List<String> thirds = new ArrayList <> ();
        
        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                thirds.add(words[i + 2]);
            } //if
        } //for

        String [] sol = new String [thirds.size()];
        for (int i = 0; i < thirds.size(); i++) {
            sol[i] = thirds.get(i);
        } //for
        return sol;
    } //findOccurences
} //Sol