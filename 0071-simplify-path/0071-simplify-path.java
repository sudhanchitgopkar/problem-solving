class Solution {
    public String simplifyPath(String path) {
        Stack <String> canonical = new Stack <> ();
        String [] paths = path.split("/");
        StringBuilder sol = new StringBuilder();
        
        for (String p : paths) {
            if (p.equals("..") && canonical.size() >= 1) canonical.pop();
            else if (p.equals("..")) continue;
            else if (p.equals(".")) continue;
            else if (p.length() > 0) canonical.push(p);
        } //for
        
        if (canonical.isEmpty()) return "/";
        
        while (!canonical.isEmpty()) {
            sol.insert(0, "/" + canonical.pop());
        } //while
        
        return sol.toString();
    } //simplify
} //Sol