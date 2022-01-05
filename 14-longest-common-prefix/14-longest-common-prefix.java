class Solution {
    public String longestCommonPrefix(String[] strs) {
        
        if (strs.length == 1)
            return strs[0];
        
        String prefix = "";
        int curri = 0;
        char curr;
        
        while(curri < strs[0].length()) {
            for (int i = 0; i < strs.length; i++) {
                if (curri >= strs[i].length()) 
                    return prefix;
                else 
                    if(strs[i].charAt(curri) != strs[0].charAt(curri))
                        return prefix;
                    if(i == strs.length-1)
                        prefix+=strs[i].charAt(curri);
            } //for
            curri++;
        } //while
        return prefix;
    } //longestCommonPrefix
} //Solution