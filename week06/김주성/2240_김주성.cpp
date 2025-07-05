#include<bits/stdc++.h>
using namespace std;

int T, W;
int dp[2][31][3]; 

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> T >> W;

    for (int t = 1; t <= T; t++) {
        int p; 

        int cur = t % 2;
        int prev = (t - 1) % 2;

        
        dp[cur][0][2] = 0; 
        dp[cur][0][1] = dp[prev][0][1] + (p == 1 ? 1 : 0);

        // w > 0 case
        for (int w = 1; w <= W; w++) {
            
            dp[cur][w][1] = max(dp[prev][w][1], dp[prev][w-1][2]) + (p == 1 ? 1 : 0);

           
            dp[cur][w][2] = max(dp[prev][w-1][1], dp[prev][w][2]) + (p == 2 ? 1 : 0);
        }
    }

    int ans = 0;
    int last = T % 2;
    for (int w = 0; w <= W; w++) {
        ans = max(ans, dp[last][w][1]);
        ans = max(ans, dp[last][w][2]);
    }

    cout << ans << '\n';

    return 0;
}
