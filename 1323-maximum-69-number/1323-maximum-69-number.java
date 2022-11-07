class Solution {
    public int maximum69Number (int num) {
        boolean flipped = false;
        String n = String.valueOf(num);
        StringBuilder s = new StringBuilder();
        
        for (char c : n.toCharArray()) {
            if (c == '6' && !flipped) {
                s.append('9');
                flipped = true;
            } else {
                s.append(c);
            } //if
        } //for
        
        return Integer.parseInt(s.toString());
    }
}