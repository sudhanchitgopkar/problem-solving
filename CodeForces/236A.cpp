#include <bits/stdc++.h>
#include <unordered_set>
#include <iostream>

using namespace std;

void solve() {
  unordered_set<char> letters;
  string username;
  
  cin >> username;
  for (char c : username) letters.insert(c);
  
  cout << (letters.size() % 2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!");
} //solve

int main() {
  solve();
  return 0;
} //main
