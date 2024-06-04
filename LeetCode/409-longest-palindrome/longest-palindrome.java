class Solution {
    public int longestPalindrome(String s) {
        int sol = 0, hasOdd = 0;
        HashMap <Character, Integer> freq = new HashMap <> ();

        for (char c : s.toCharArray()) freq.put(c, freq.getOrDefault(c, 0) + 1);
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue());
            sol += entry.getValue() - (entry.getValue() % 2 == 0 ? 0 : 1);
            if (entry.getValue() % 2 == 1) hasOdd = 1;
        } //for

        return sol + hasOdd;
    } //longestPalindrome
} //Sol