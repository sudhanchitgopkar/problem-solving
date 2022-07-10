class Solution {
    public String addBinary(String a, String b) {
        String sol = "";
        boolean carry = false;
        
        for (int i = Math.min(a.length(),b.length()); i < Math.max(a.length(),b.length()); i++) {
            if (a.length() < b.length()) a = "0" + a;
            else b = "0" + b;
        } //for
        
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == b.charAt(i)) {
                if (a.charAt(i) == '0' && carry) { sol = "1" + sol; carry = false; }
                else if (a.charAt(i) == '0') { sol = "0" + sol; carry = false; }
                else if (carry) { sol = "1" + sol;}
                else { sol = "0" + sol; carry = true;}
            } else {
                if (carry) {sol = "0" + sol;}
                else {sol = "1" + sol;}
            } //if
        } //for
        
        if (carry) return "1" + sol;
        return sol;
    } //addBin
} //Solution