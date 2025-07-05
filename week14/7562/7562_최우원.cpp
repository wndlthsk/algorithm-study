#include <iostream>
#include <queue>
#include <vector>
#include <cstring>  // memset
using namespace std;

const int dx[8] = {-2, -1, 1, 2, 2, 1, -1, -2};
const int dy[8] = {1, 2, 2, 1, -1, -2, -2, -1};

int visited[301][301];

int bfs(int l, int sx, int sy, int ex, int ey) {
    memset(visited, -1, sizeof(visited));
    queue<pair<int, int>> q;
    q.push({sx, sy});
    visited[sx][sy] = 0;

    while (!q.empty()) {
        auto [x, y] = q.front(); q.pop();

        if (x == ex && y == ey)
            return visited[x][y];

        for (int i = 0; i < 8; ++i) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < l && ny < l && visited[nx][ny] == -1) {
                visited[nx][ny] = visited[x][y] + 1;
                q.push({nx, ny});
            }
        }
    }

    return -1; // 절대 도달 못 하는 경우 (없음)
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T; cin >> T;
    while (T--) {
        int l; cin >> l;
        int sx, sy, ex, ey;
        cin >> sx >> sy >> ex >> ey;
        cout << bfs(l, sx, sy, ex, ey) << '\n';
    }
    return 0;
}
