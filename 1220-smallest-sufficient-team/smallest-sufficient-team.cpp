class Solution {
public:
    vector<int> smallestSufficientTeam(vector<string>& req_skills, vector<vector<string>>& people) {
        unordered_map <string, int> skillToBit;
        queue <pair<int, vector<int>>> q;
        unordered_set<int> seen;

        //convert a skill to a bit position
        int bit = 0;
        for (string skill : req_skills) {
            skillToBit[skill] = bit++;
            //cout << skill << "\t" << bit - 1 << "\n";
        } //for
        cout << ((2 << (bit - 1)) - 1);

        for (int i = 0; i < people.size(); i++) {
            int state = personToBit(people[i], skillToBit);
            if (state == ((2 << (bit - 1)) - 1)) return {i};
            pair <int, vector<int>> p (state, {i});
            q.push(p);
            seen.insert(state);
        } //for

        while (!q.empty()) {
            pair <int, vector<int>> curr = q.front();
            int state = curr.first;
            q.pop();

            for (int i = 0; i < people.size(); i++) {
                int p2b = personToBit(people[i], skillToBit);
                if (!seen.count(state | p2b)) {
                    vector<int> copy = curr.second;
                    copy.push_back(i);
                    if ((state | p2b) == ((2 << (bit - 1)) - 1)) {
                        return copy;
                    } else {
                        pair <int, vector<int>> p ((state | p2b), copy);
                        q.push(p);
                        seen.insert((state | p2b));
                    } //if
                } //if
            } //for
        } //while

        return {}; //unreachable
    } //smallestSufficient

    int personToBit (vector<string>& person, unordered_map<string, int>& skillToBit) {
        int val = 0;

        for (string skill : person) {
            //cout << skill << " ";
            if (skillToBit.count(skill)) {
                val += (1 << skillToBit[skill]);
            } //if
        } //for
        //cout << "VAL: " << val << "\n";
        return val;
    } //if
};