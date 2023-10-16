class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<int> prev = {1}, curr = {1};

        for (int i = 1; i <= rowIndex; i++) {
            curr.clear();
            curr.push_back(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                curr.push_back(prev[j] + prev[j + 1]);
            } //for
            curr.push_back(1);

            prev = curr;
        } //for

        return curr;
    } //getRow
};