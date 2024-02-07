class Solution {
    public String frequencySort(String s) {
        HashMap <Character, Integer> freq = new HashMap <> ();
        String [] sorted = new String [s.length()+1];

        for (int i = 0; i < sorted.length; i++) sorted[i] = "";  
        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);

        for (char key : freq.keySet()) { 
            for (int i = 0; i < freq.get(key); i++) sorted[freq.get(key)] += key;
        }
        
        StringBuilder sol = new StringBuilder(String.join("", sorted));
        return sol.reverse().toString();
    } //freqSort
} //Sol