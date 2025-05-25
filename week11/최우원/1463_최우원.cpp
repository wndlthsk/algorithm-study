#include <iostream>
#include <algorithm>
using namespace std;

int dp[1000001]; // 최대 10^6까지 입력 가능

int main() {
    int n;
    cin >> n;

    dp[1] = 0; // 1은 0번의 연산으로 1이 됨

    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i - 1] + 1; // 1을 빼는 연산

        if (i % 2 == 0)
            dp[i] = min(dp[i], dp[i / 2] + 1);

        if (i % 3 == 0)
            dp[i] = min(dp[i], dp[i / 3] + 1);
    }

    cout << dp[n] << endl;
    return 0;
}
