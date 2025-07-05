#include <bits/stdc++.h>
using namespace std;
#define INF 1e9

int n, m;
vector<pair<int, int>> graph[1001];
int dist[1001];

void dijkstra(int start) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    pq.push({0, start});
    dist[start] = 0;

    while (!pq.empty()) {
        int cost = pq.top().first;
        int cur = pq.top().second;
        pq.pop();

        if (dist[cur] < cost) continue;

        for (auto& edge : graph[cur]) {
            int next = edge.first;
            int nextCost = edge.second;

            if (dist[next] > cost + nextCost) {
                dist[next] = cost + nextCost;
                pq.push({dist[next], next});
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m;

    // 거리 배열 초기화
    fill(dist, dist + 1001, INF);

    // 버스 정보 입력
    for (int i = 0; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].push_back({v, w});
    }

    int start, end;
    cin >> start >> end;

    // 다익스트라 실행
    dijkstra(start);

    // 최단 거리 출력
    cout << dist[end] << "\n";

    return 0;
}
