class Solution {
public:
    bool asteroidsDestroyed(int mass, vector<int>& asteroids) {
        long long m = mass;
        sort(asteroids.begin(), asteroids.end());
        
        for (int i = 0; i < asteroids.size(); i++) {
            if (m < asteroids[i]) return false;
            m += asteroids[i];
        } //for

        return true;
    } //asteroidsDestroyed
};