class Solution {
public:
    int findNumbers(vector<int>& nums) {
        int sol = 0;
        for (auto num : nums) sol += isEvenDigits(num) ? 1 : 0;
        return sol;
    } //findNums

    bool isEvenDigits(int num) {
        int digits = 0;

        while (num != 0) {
            num /= 10;
            digits++;
        } //while

        return digits % 2 == 0;
    } //isEvenDigs
};