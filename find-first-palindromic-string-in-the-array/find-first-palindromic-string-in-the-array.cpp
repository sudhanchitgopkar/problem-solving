class Solution {
public:
    string firstPalindrome(vector<string>& words) {
        for (string word : words) {
            string_view sv (word);
            if (isPal(sv)) return static_cast<string>(sv);
        } //for
        return "";
    } //firstPalindrome

    bool isPal(string_view word) {
        int n = word.size(); 
        for (int i = 0; i < n/2; i++) {
            if (word.at(i) != word.at(n - 1 - i)) return false;
        } //for
        return true;
    } //isPal
};