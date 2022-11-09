class Solution {
    public int calPoints(String[] ops) {
        Stack <Integer> s = new Stack <> ();
        int sol = 0;
        
        for (String o : ops) {
            if (o.equals("D")) {
                s.push(2*s.peek());
            } else if (o.equals("C")) {
                s.pop();
            } else if (o.equals("+")) {
                int top = s.pop(), sec = s.peek();
                s.push(top);
                s.push(top + sec);
            } else {
                s.push(Integer.parseInt(o));
            } //if
        } //for
        
        while (!s.isEmpty()) sol += s.pop();
        return sol;
    } //calPoints
} //Sol