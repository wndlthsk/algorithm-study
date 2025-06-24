#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
using namespace std;

const int dx[8] = {-2, -1, 1, 2, 2, 1, -1, -2};
const int dy[8] = {1, 2, 2, 1, -1, -2, -2, -1};

int dist[501][501];  // 이동 횟수 저장
int N, M;

void bfs(int sx, int sy) {
    memset(dist, -1, sizeof(dist));
    queue<pair<int, int>> q;
    q.push({sx, sy});
    dist[sx][sy] = 0;

    while (!q.empty()) {
        auto [x, y] = q.front(); q.pop();

        for (int i = 0; i < 8; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx <= N && ny <= N && dist[nx][ny] == -1) {
                dist[nx][ny] = dist[x][y] + 1;
                q.push({nx, ny});
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;

    int sx, sy;
    cin >> sx >> sy;

    bfs(sx, sy);  // 한 번만 수행

    for (int i = 0; i < M; ++i) {
        int ex, ey;
        cin >> ex >> ey;
        cout << dist[ex][ey] << " ";
    }

    return 0;
}
