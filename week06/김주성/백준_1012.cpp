#include<bits/stdc++.h> 
using namespace std;     

int M, N, K;           
int board[51][51];     // 배추밭 상태
bool vis[51][51];      
int dx[4] = {1, -1, 0, 0}; 
int dy[4] = {0, 0, 1, -1}; 

// BFS 
void bfs(int start_x, int start_y) {
    queue<pair<int, int>> q;
    q.push({start_x, start_y});
    vis[start_x][start_y] = true; // 시작점 방문 표시

    while (!q.empty()) {
        pair<int, int> cur = q.front();
        q.pop();

        for (int dir = 0; dir < 4; dir++) { // 4방향 탐색
            int nx = cur.first + dx[dir];
            int ny = cur.second + dy[dir];

            
            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

           
            if (board[nx][ny] == 1 && !vis[nx][ny]) {
                q.push({nx, ny});       // 큐에 추가
                vis[nx][ny] = true;     // 방문 표시
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(0); 
    cin.tie(0);             /

    int T; // 테스트 케이스 개수
    cin >> T;

    while (T--) { 
        cin >> M >> N >> K; 

        // 배열 초기화
       
        memset(board, 0, sizeof(board)); // board 배열 0으로 초기화
        memset(vis, 0, sizeof(vis));     // vis  초기화

        
        for (int i = 0; i < K; i++) {
            int x, y;
            cin >> x >> y; 
            board[y][x] = 1; 
        }

        int worm_count = 0; 

        // 전체 배추밭 순회 (주어진 코드 스타일: 이중 for문)
        for (int i = 0; i < N; i++) {     
            for (int j = 0; j < M; j++) { 
                // 배추가 있고(board[i][j] == 1) 아직 방문하지 않았다면(!vis[i][j])
                if (board[i][j] == 1 && !vis[i][j]) {
                    worm_count++;      // 새로운 연결 요소 발견, 지렁이 수 증가
                    bfs(i, j);         // 해당 위치에서 BFS 연결된 모든 배추 방문 처리
                }
            }
        }

        cout << worm_count << '\n'; 
    }

    return 0;
}
