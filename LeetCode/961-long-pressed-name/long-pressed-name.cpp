class Solution {
public:
    bool isLongPressedName(string name, string typed) {
        int m = name.size(), n = typed.size(), j = 0;
        int prevFreq = 0;    
    
        for (int i = 0; i < m; i++) {
            if (i > 0 && name[i] == name[i - 1]) {
                if (--prevFreq < 0) return false; 
            } else {
                prevFreq = 0;
                if (name[i] != typed[j++]) return false;
                while (j < n && name[i] == typed[j]) {
                    j++;
                    prevFreq++;
                } //while
            } //if
        } //for

        return j == n ? true : false;
    } //isLongPressed
};