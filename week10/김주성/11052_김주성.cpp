#include <bits/stdc++.h>

using namespace std;

int p[1001];
int dp[1001];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 1; i <= n; ++i) {
        cin >> p[i];
    }

    dp[0] = 0; // 0장을 구매하는 비용은 0

    for (int i = 1; i <= n; ++i) { /it/ dp[i]를 계산: i장의 카드를 구매하는 최대 비용
        for (int j = 1; j <= i; ++j) { // j장짜리 카드팩을 구매하는 경우를 고려
            dp[i] = max(dp[i], dp[i - j] + p[j]);
        }
    }

    cout << dp[n] << "\n";

    return 0;
}
