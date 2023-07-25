class Solution {
public:
    int countCollisions(string dirs) {
        stack <char> s;
        int sol = 0;

        s.push(dirs[0]);
        for (int i = 1; i < dirs.size(); i++) {
            if (dirs[i] == 'L') {
                if (s.top() == 'R' || s.top() == 'S') {
                    sol += s.top() == 'R' ? 2 : 1;
                    s.pop();
                    s.push('S');
                } else {
                    s.push('L');
                } //if
            } else if (dirs[i] == 'R') {
                s.push('R');
            } else {
                if (s.top() == 'R') {
                    sol++;
                    s.pop();
                } //if
                s.push('S');
            } //if
        } //for

        char prev = s.top();
        s.pop();
        while (!s.empty()) {
            if (s.top() == 'R' && prev == 'S') {
                sol++;
                prev = 'S';
            } else {
                prev = s.top();
            } //if
            s.pop();
        } //while

        return sol;
    } //count
};