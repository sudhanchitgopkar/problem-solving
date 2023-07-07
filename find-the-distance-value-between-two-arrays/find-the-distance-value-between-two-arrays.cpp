class Solution {
public:
    int findTheDistanceValue(vector<int>& a, vector<int>& b, int d) {
        int sol = 0;

        for (int na : a) {
            bool has = false;
            for (int nb : b) {
                if (abs(na - nb) <= d) {
                    has = true;
                    break;
                } //if
            } //for
            if (!has) sol++;
        } //for

       return sol;
    } //findDist
};