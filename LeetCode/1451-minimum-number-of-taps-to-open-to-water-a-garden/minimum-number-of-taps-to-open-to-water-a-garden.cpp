class Solution {
public:
    int minTaps(int n, vector<int>& ranges) {
    vector<int> v(ranges.size(), 0); // v[i] -> which tap covers tap i and covers the most taps to the right

    for (int i = 0; i <= n; i ++)
    {   
        int r = ranges[i];
        if (r == 0)
            continue;
		// int right = min(n, i + r); // this works if you don't need to cover the area between the taps
        int right = min(n, i + r == n ? n : i + r - 1);
        for (int j = max(0, i - r); j <= right; j ++)
            v[j] = max(v[j], right);
    }
    
    int res = 0;
    for (int i = 0; i <= n; i ++)
    {
        if (v[i] == 0)
            return -1;
        
        i = v[i]; // last one covered
        res ++;
    }

    return res;
}
};