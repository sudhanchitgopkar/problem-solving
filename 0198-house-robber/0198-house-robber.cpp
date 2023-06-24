class Solution {
public:
    int rob(vector<int>& rob) {
        
        int n = rob.size();
        
        if (n == 1) return rob[0];
        rob[n - 2] = max(rob[n - 1], rob[n - 2]);
        
        for (int i = n - 3; i >= 0; i--) {
            rob[i] = max(rob[i] + rob[i + 2], rob[i + 1]);    
        } //for
        
        return max(rob[0], rob[1]);
    } //rob
};