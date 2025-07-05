#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n;
    cin >> n;

    vector<int> v(n);
    for (int i = 0; i < n; ++i) {
        cin >> v[i];
    }

    sort(v.begin(), v.end());

    int l = 0;
    int r = n - 1;
    
    long long min_abs_s = -1; 
    int ans = 0;

    min_abs_s = abs((long long)v[l] + v[r]);
    ans = v[l] + v[r];
    
    while (l < r) {
        long long cur_s = (long long)v[l] + v[r];
        long long cur_abs_s = abs(cur_s);

        if (cur_abs_s < min_abs_s) {
            min_abs_s = cur_abs_s;
            ans = cur_s;
        }

        if (cur_s == 0) {
            break;
        } else if (cur_s < 0) {
            l++;
        } else {
            r--;
        }
    }

    cout << ans << "\n";

    return 0;
}
