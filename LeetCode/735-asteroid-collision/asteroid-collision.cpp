class Solution {
public:
    vector<int> asteroidCollision(vector<int>& asteroids) {
        vector <int> survivors;

        for (int asteroid : asteroids) {
            if (asteroid >= 0) {
                survivors.push_back(asteroid);
                cout << "PUSHED: " << asteroid << "\n";
            } else {
                if (survivors.empty()) {
                    survivors.push_back(asteroid);
                    cout << "PUSHED: " << asteroid << "\n";
                } else {
                    bool done = false;
                    while (!done) {
                        int survivor = survivors.size() == 0 ? -1: survivors[survivors.size() - 1];
                        if (survivors.empty() || survivor < 0) {
                            survivors.push_back(asteroid);
                            cout << "PUSHED: " << asteroid << "\n";
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