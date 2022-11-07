class Solution {
    public int maximum69Number (int num) {
        StringBuilder s = new StringBuilder(String.valueOf(num));
        if (s.indexOf("6") != -1) s.setCharAt(s.indexOf("6"),'9'); 
        return Integer.parseInt(s.toString());
    } //max69Number
} //Solution