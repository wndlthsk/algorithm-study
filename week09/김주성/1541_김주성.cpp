#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    int ans = 0;
    string seg; 
    bool is_fir = true;

    for (int i = 0; i <= s.length(); ++i) {
        if (i == s.length() || s[i] == '-') {
            int c_sum = 0;
            string num_s;
            for (int j = 0; j <= seg.length(); ++j) {
                if (j == seg.length() || seg[j] == '+') {
                    if (!num_s.empty()) {
                        c_sum += stoi(num_s);
                        num_s = "";
                    }
                } else {
                    num_s += seg[j];
                }
            }
            
            if (is_fir) {
                ans += c_sum;
                is_fir = false;
            } else {
                ans -= c_sum;
            }
            seg = ""; 
        } else {
            seg += s[i]; 
        }
    }

    cout << ans << "\n";

    return 0;
}
