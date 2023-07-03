class Solution {
public:
    int countOdds(int low, int high) {
        if (low % 2 == 0 && high % 2 == 0) {
            return (high-low)/2;
        } else if (low % 2 == 1 && high %2 == 1) {
            return (high-low)/2 + 1;
        } else {
            return (high-low)/2 + 1;
        } //if
    } //countOdds
};

//6 - 2: 3, 5
//11, 5: 5, 7, 9, 11
//11, 6: 7, 9, 11