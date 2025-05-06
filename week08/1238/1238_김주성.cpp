#include <bits/stdc++.h>

using namespace std;

const int INF = 0x3f3f3f3f;

int n, m, x;
vector<pair<int, int>> adj[1001];
vector<pair<int, int>> rev[1001];
int d1[1001];
int d2[1001];

void dijk(int st, vector<pair<int, int>> g[], int dr[]) {
    for (int i = 1; i <= n; ++i) {
        dr[i] = INF;
    }
    dr[st] = 0;

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, st});

    while (!pq.empty()) {
        int cur_d = pq.top().first;
        int cur = pq.top().second;
        pq.pop();

        if (cur_d > dr[cur]) {
            continue;
        }

        for (auto& edge : g[cur]) {
            int nxt = edge.first;
            int c = edge.second; // cost
            if (dr[cur] + c < dr[nxt]) {
                dr[nxt] = dr[cur] + c;
                pq.push({dr[nxt], nxt});
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n >> m >> x;

    for (int i = 0; i < m; ++i) {
        int u_node, v_node, t_cost; // 입력 받을 때 임시 변수
        cin >> u_node >> v_node >> t_cost;
        adj[u_node].push_back({v_node, t_cost});
        rev[v_node].push_back({u_node, t_cost});
    }

    dijk(x, rev, d1);
    dijk(x, adj, d2);

    int max_t = 0;
    for (int i = 1; i <= n; ++i) {
        if (d1[i] != INF && d2[i] != INF) {
            max_t = max(max_t, d1[i] + d2[i]);
        }
    }

    cout << max_t << "\n";

    return 0;
}
