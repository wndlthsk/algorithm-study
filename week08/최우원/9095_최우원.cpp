#include <iostream>
using namespace std;

int dp[12]; // n은 최대 11

int main() {
    int T, n;
    cin >> T;

    // 초기값 설정
    dp[1] = 1; // 1
    dp[2] = 2; // 1+1, 2
    dp[3] = 4; // 1+1+1, 1+2, 2+1, 3

    while (T--) {
        cin >> n;

        for (int i = 4; i <= n; ++i) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        cout << dp[n] << '\n';
    }

    return 0;
}
