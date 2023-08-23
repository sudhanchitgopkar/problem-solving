class Solution {
public:
    long long numberOfWays(string s) {
        unordered_map<string, long long> freq;
        freq.insert({"0", 0});
        freq.insert({"01", 0});
        freq.insert({"010", 0});
        freq.insert({"1", 0});
        freq.insert({"10", 0});
        freq.insert({"101", 0});
        
        for (char c : s) {
            if (c == '0') {
                freq["0"]++;
                freq["010"] += freq["01"];
                freq["10"] += freq["1"];
            } else {
                freq["1"]++;
                freq["01"] += freq["0"];
                freq["101"] += freq["10"];
            } //if
        } //for


        return freq["010"] + freq["101"];
    } //numWays
};

/*
1,1,1,0,0

 0   01  010
[2] [0]  [0]

 1   10  101
[3] [6]  [0]

num0s 3 2 2 2 1 0
num1s 3 3 3 2 2 1

1 -> 0
2 -> 0
3 -> 
    - 010
    - 101
*/