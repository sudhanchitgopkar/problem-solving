#include <bits/stdc++.h>
#include <unordered_set>
#include <iostream>

using namespace std;

void solve() {
  int color;
  unordered_set<int> colors;
  
  for (int i = 0; i < 4; i++) {
    cin >> color;
    colors.insert(color);
  } //for
  
  if (colors.size() >= 4) cout << 0;
  else cout << 4 - colors.size(); 
} //solve

int main() {
  solve();
  return 0;
} //main
