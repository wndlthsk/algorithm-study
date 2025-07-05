#include <bits/stdc++.h>

using namespace std;

struct Box {
    int s, e, num;
};

bool cmp(const Box& a, const Box& b) {
    if (a.e != b.e) {
        return a.e < b.e;
    }
    return a.s < b.s;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int n, c;
    cin >> n >> c;

    int m;
    cin >> m;

    vector<Box> r(m);
    for (int i = 0; i < m; ++i) {
        cin >> r[i].s >> r[i].e >> r[i].num;
    }

    sort(r.begin(), r.end(), cmp);

    vector<int> l(n + 1, 0);
    long long ans = 0;

    for (int i = 0; i < m; ++i) {
        int fs = r[i].s;
        int fe = r[i].e;
        int cnt = r[i].num;

        int mlp = 0;
        for (int j = fs; j < fe; ++j) {
            mlp = max(mlp, l[j]);
        }

        int avail = c - mlp;
        int take = min(cnt, avail);

        if (take > 0) {
            ans += take;
            for (int j = fs; j < fe; ++j) {
                l[j] += take;
            }
        }
    }

    cout << ans << "\n";

    return 0;
}
