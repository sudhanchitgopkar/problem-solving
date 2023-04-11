class Solution {
    public String removeStars(String s) {
        Stack <Character> chars = new Stack <> ();
        StringBuilder sol = new StringBuilder();

        for (char c : s.toCharArray())
            if (c == '*') chars.pop();
            else chars.push(c);

        while (!chars.isEmpty()) sol.insert(0, chars.pop());
        return sol.toString();
    } //remStars
} //Sol