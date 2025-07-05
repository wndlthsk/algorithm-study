#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

const int INF = 1e9;
int N, M, X;

vector<pair<int, int>> graph[1001]; // 정방향 그래프 (가는데)
vector<pair<int, int>> reverse_graph[1001]; // 역방향 그래프 (돌아오는데)
int dist[1001]; // X에서 각 마을로 가는 거리
int reverse_dist[1001]; // 각 마을에서 X로 오는 거리

void dijkstra(int start, vector<pair<int, int>>* g, int* d) {
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    fill(d, d + N + 1, INF);
    d[start] = 0;
    pq.push({0, start});
    
    while (!pq.empty()) {
        int current_dist = pq.top().first;
        int current_node = pq.top().second;
        pq.pop();
        
        if (d[current_node] < current_dist) continue;
        
        for (auto& edge : g[current_node]) {
            int next_node = edge.first;
            int next_dist = current_dist + edge.second;
            
            if (next_dist < d[next_node]) {
                d[next_node] = next_dist;
                pq.push({next_dist, next_node});
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> N >> M >> X;
    
    for (int i = 0; i < M; i++) {
        int a, b, t;
        cin >> a >> b >> t;
        graph[a].push_back({b, t}); // 정방향 그래프
        reverse_graph[b].push_back({a, t}); // 역방향 그래프
    }
    
    // X에서 모든 마을로 가는 최단 거리 (정방향 그래프 사용)
    dijkstra(X, graph, dist);
    
    // 모든 마을에서 X로 오는 최단 거리 (역방향 그래프 사용)
    dijkstra(X, reverse_graph, reverse_dist);
    
    int max_time = 0;
    for (int i = 1; i <= N; i++) {
        if (i == X) continue;
        max_time = max(max_time, dist[i] + reverse_dist[i]);
    }
    
    cout << max_time << "\n";
    
    return 0;
}
