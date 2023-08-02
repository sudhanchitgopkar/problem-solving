#include <bits/stdc++.h>
#include <iostream>

using namespace std;

void solve() {
  int n;
  cin >> n;
  
  if (n % 2 == 1) {
    cout << -1;
  } else {
    int curr = 2;
    while (curr <= n) {
      cout << curr << " " << curr - 1 << " ";
      curr += 2;
    } //while
  } //if
} //solve

int main () {
  solve();
  return 0;
} //main
