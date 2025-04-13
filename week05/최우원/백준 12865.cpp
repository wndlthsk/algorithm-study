#include <bits/stdc++.h>
using namespace std;

int dp[100001]; // 무게 K까지의 최대 가치 저장

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int N, K;
    cin >> N >> K;

    vector<pair<int, int>> items(N); // {무게, 가치}
    for (int i = 0; i < N; i++) {
        int w, v;
        cin >> w >> v;
        items[i] = {w, v};
    }

    // 물건 하나씩 고려
    for (int i = 0; i < N; i++) {
        int weight = items[i].first;
        int value = items[i].second;

        // **뒤에서부터** 업데이트해야 중복 사용을 막을 수 있음 (0-1 배낭이기 때문)
        for (int j = K; j >= weight; j--) {     // 지금 현재 물건이 최대가능무게보다 작다면 무조건 넣는다.
            dp[j] = max(dp[j], dp[j - weight] + value); 
        }
    }

    cout << dp[K]; // 무게 K일 때 최대 가치
}
