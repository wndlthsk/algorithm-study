#include <bits/stdc++.h>

using namespace std;

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    string s;
    cin >> s;

    if (s.length() == 0) {
        cout << 0 << "\n";
        return 0;
    }

    int c0 = 0;
    int c1 = 0;

    if (s[0] == '0') {
        c0++;
    } else {
        c1++;
    }

    for (int i = 0; i < s.length() - 1; ++i) {
        if (s[i] != s[i+1]) {
            if (s[i+1] == '0') {
                c0++;
            } else {
                c1++;
            }
        }
    }

    cout << min(c0, c1) << "\n";

    return 0;
}
