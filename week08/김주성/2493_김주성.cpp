#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, k;
    cin >> n >> k;

    vector<int> coins(n);
    for (int i = 0; i < n; ++i) {
        cin >> coins[i];
    }

    vector<int> dp(k + 1, 0);
    dp[0] = 1;

    for (int coin : coins) {
        for (int j = coin; j <= k; ++j) {
            if (j - coin >= 0) {
                dp[j] += dp[j - coin];
            }
        }
    }

    cout << dp[k] << '\n';

    return 0;
}
