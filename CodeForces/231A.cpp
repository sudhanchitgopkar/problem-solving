#include <bits/stdc++.h>
#include <iostream>

using namespace std;

void solve() {
    int N, a, b, c, sol = 0;
    cin >> N;

    for (int i = 0; i < N; i++) {
        cin >> a;
        cin >> b; 
        cin >> c;
        if (a + b + c >= 2) sol++;
    } //for

    cout << sol;
} //solve

int main() {
  solve();
  return 0;
} //main
