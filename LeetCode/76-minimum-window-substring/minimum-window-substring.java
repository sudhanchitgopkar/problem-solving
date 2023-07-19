class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        int [] tfreq = new int [128];
        int [] window = new int [128];
        int l = 0;
        int lMin = Integer.MAX_VALUE, gMin = Integer.MAX_VALUE;
        int matches = 0;
        String sol = "";
        
        //populate tFreq
        for (int i = 0; i < t.length(); i++)
            tfreq[t.charAt(i)]++;
        
        //populate window
        for (int i = 0; i < t.length() - 1; i++) {
            window[s.charAt(i)]++;
            if (window[s.charAt(i)] <= tfreq[s.charAt(i)]) matches++;
        } //for
        
        //main
        for (int r = t.length() - 1; r < s.length(); r++) {
            window[s.charAt(r)]++;
            if (window[s.charAt(r)] <= tfreq[s.charAt(r)]) matches++;
            
            while (matches == t.length()) {
                lMin = r - l + 1;
                if (lMin < gMin) {
                    gMin = lMin;
                    sol = s.substring(l,r+1);
                } //if
                window[s.charAt(l)]--;
                if (window[s.charAt(l)] < tfreq[s.charAt(l)]) matches--;
                l++;
            } //while
        } //for
        
        System.gc();
        return sol;
    } //minWin
} //Sol