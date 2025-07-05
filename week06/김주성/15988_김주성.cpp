#include<bits/stdc++.h>
using namespace std;

const int MOD = 1000000009;
const int MAX_N = 1000000;
long long dp[MAX_N + 1];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for (int i = 4; i <= MAX_N; i++) {
        dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % MOD;
    }

    int T;
    cin >> T;

    while (T--) {
        int n;
        cin >> n;
        cout << dp[n] << '\n';
    }

    return 0;
}
