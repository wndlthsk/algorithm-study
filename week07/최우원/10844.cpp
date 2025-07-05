#include <bits/stdc++.h>
using namespace std;
long long d[101][10];
int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);
  int n;
  cin >> n;
  for (int i = 1; i <= 9; ++i) d[1][i] = 1;
  
  for (int i = 2; i <= n; ++i) {
    for (int k = 0; k <= 9; ++k) {
      if (k != 0) d[i][k] += d[i - 1][k - 1];
      if (k != 9) d[i][k] += d[i - 1][k + 1];
      d[i][k] %= 1000000000;
    }
  }
  long long ans = 0;
  for (int i = 0; i <= 9; ++i) {
    ans += d[n][i];
  }
  ans %= 1000000000;
  cout << ans;
}
