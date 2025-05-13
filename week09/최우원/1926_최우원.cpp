#include <bits/stdc++.h>
using namespace std;

int n, m;
int board[501][501];    // 그림을 저장할 2차원 배열
bool vis[501][501];     // 방문 여부 체크
int dx[4] = {1, -1, 0, 0}; // 상하좌우 이동
int dy[4] = {0, 0, 1, -1};

int bfs(int x, int y) {
    queue<pair<int, int>> q;
    q.push({x, y});
    vis[x][y] = true;
    int area = 1; // 현재 그림의 넓이

    while (!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();

        for (int dir = 0; dir < 4; dir++) {
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];

            // 경계를 벗어나면 무시
            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            // 이미 방문했거나 그림이 아니면 무시
            if (vis[nx][ny] || board[nx][ny] == 
