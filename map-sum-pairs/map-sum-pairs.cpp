class MapSum {
public:
    unordered_map<string, int> ms;

    MapSum() {
        //yeehaw
    } //mapsum
    
    void insert(string key, int val) {
        ms[key] = val;
    } //insert
    
    int sum(string prefix) {
        int sum = 0;
        for (auto entry : ms) {
            if (hasPre(prefix, entry.first)) {
                sum += entry.second;
            } //if
        } //for
        return sum;
    } //sum

    bool hasPre(string pre, string s) {
        if (s.size() < pre.size()) return false;

        for (int i = 0; i < pre.size(); i++) {
            if (s.at(i) != pre.at(i)) return false;
        } //for

        return true;
    } //hasPre
};