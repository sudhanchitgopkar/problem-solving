class Solution {
public:
    unordered_map<string, string> um;
    int id = 0;
    // Encodes a URL to a shortened URL.
    string encode(string longUrl) {
        um[to_string(id)] = longUrl;
        return to_string(id++);
    } //encode

    // Decodes a shortened URL to its original URL.
    string decode(string shortUrl) {
        return um[shortUrl];
    } //decode
};

// Your Solution object will be instantiated and called as such:
// Solution solution;
// solution.decode(solution.encode(url));