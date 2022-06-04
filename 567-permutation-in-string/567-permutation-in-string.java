class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        
        int [] s1freq = new int [26];
        int [] window = new int [26];
        int l = 0;
        
        for (int i = 0; i < s1.length(); i++)
            s1freq[s1.charAt(i) - 'a']++;
        
        for (int i = 0; i < s1.length()-1; i++) 
            window[s2.charAt(i) - 'a']++;
            
        for (int r = s1.length()-1; r < s2.length(); r++) {
            window[s2.charAt(r)-'a']++;
            
            if (Arrays.equals(s1freq,window)) {
              return true;  
            } else {
                window[s2.charAt(l) - 'a']--;
                l++;
            } //if
        } //for
        
        return false;
    } //incl
} //Sol