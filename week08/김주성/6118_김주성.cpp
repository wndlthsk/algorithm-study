#include <bits/stdc++.h>

using namespace std;

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> adj(n + 1);
    for (int i = 0; i < m; ++i) {
        int u, v;
        cin >> u >> v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    vector<int> dist(n + 1, -1);
    queue<int> q;

    dist[1] = 0;
    q.push(1);

    int max_d = 0;

    while (!q.empty()) {
        int u = q.front();
        q.pop();

        max_d = max(max_d, dist[u]);

        for (int v : adj[u]) {
            if (dist[v] == -1) {
                dist[v] = dist[u] + 1;
                q.push(v);
            }
        }
    }

    int ans_idx = -1;
    int cnt = 0;

    for (int i = 1; i <= n; ++i) {
        if (dist[i] == max_d) {
            if (ans_idx == -1) {
                ans_idx = i;
            }
            cnt++;
        }
    }

    if (ans_idx == -1 && n >= 1) {
         ans_idx = 1;
         cnt = 1;
         max_d = 0;
    }

    cout << ans_idx << " " << max_d << " " << cnt << '\n';

    return 0;
}
