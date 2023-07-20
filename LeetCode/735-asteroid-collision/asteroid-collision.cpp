class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        vector <int> survivors;

        for (int asteroid : asteroids) {
            if (asteroid >= 0) {
                survivors.push_back(asteroid);
            } else {
                if (survivors.empty()) {
                    survivors.push_back(asteroid);
                } else {
                    bool done = false;
                    while (!done) {
                        int survivor = survivors.size() == 0 ? -1 : survivors.back();
                        if (survivors.empty() || survivor < 0) {
                            survivors.push_back(asteroid);
                            done = true;
                        } else if (abs(asteroid) > survivor) {
                            survivors.pop_back();
                        } else if (abs(asteroid) == survivor) {
                            survivors.pop_back();
                            done = true;
                        } else {
                            done = true;
                        } //if
                    } //while
                } //if
            } //if
        } //for

        return survivors;
    } //asteroidCollision
};