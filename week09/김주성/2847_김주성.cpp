#include <bits/stdc++.h>

using namespace std;

int s[100];

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    for (int i = 0; i < n; ++i) {
        cin >> s[i];
    }

    int ans = 0;

    for (int i = n - 2; i >= 0; --i) {
        if (s[i] >= s[i+1]) {
            int diff = s[i] - (s[i+1] - 1);
            ans += diff;
            s[i] = s[i+1] - 1;
        }
    }

    cout << ans << "\n";

    return 0;
}
