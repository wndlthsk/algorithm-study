#include <bits/stdc++.h>
using namespace std;
#define X first 
#define Y second 
/* 
✅ 핵심 요약
board[i]는 string → 문자열 한 줄 (즉, char들의 배열)

board[i][j]는 string 타입의 i번째 줄의 j번째 문자

즉, board[i][j]는 char 값

그래서 board[i][j]는 2차원 배열처럼 동작합니다.

주의: char*로 선언한 문자열은 수정 불가 (const 영역)
char s[10] = "Hi"; or char* s = "Hi";
*/
int dx[4] = {-1,0,1,0};
int dy[4] = {0,1,0,-1};
string board [10002];
int dist1[1002][1002];
int dist2[1002][1002];
int R,C;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    queue<pair<int,int>> Q1;
    queue<pair<int,int>> Q2;

    cin >> R >> C;

    for(int i = 0; i < R; i++)
    {
    fill(dist1[i],dist1[i]+C,-1);
    fill(dist2[i],dist2[i]+C,-1);
    }
    
    for(int i = 0; i < R; i++){
        cin >> board[i];
    }
    for(int i = 0; i < R; i++){
        for(int j = 0; j < C; j++){
            if(board[i][j] == 'F'){
                Q1.push({i,j});
                dist1[i][j] = 0;
            }
            if(board[i][j] == 'J'){
                Q2.push({i,j});
                dist2[i][j] = 0;
            }
        }
    }

    

    while(!Q1.empty()){ // 불에 대한 bfs
        auto cur = Q1.front(); Q1.pop();
        for(int i = 0; i<4; i++){
            int nx = cur.X + dx[i];
            int ny = cur.Y + dy[i];
            if(nx < 0 ||nx >= R || ny >= C || ny < 0) continue;
            if(dist1[nx][ny] != -1 || board[nx][ny] == '#') continue;
            dist1[nx][ny] = dist1[cur.X][cur.Y] + 1;
            Q1.push({nx,ny});
        }
    }

    while(!Q2.empty()){ // 지훈이에 대한 bfs
        auto cur = Q2.front(); Q2.pop();
        for(int i = 0; i<4; i++){
            int nx = cur.X + dx[i];
            int ny = cur.Y + dy[i];
            if(nx < 0 ||nx >= R || ny >= C || ny < 0) {
                cout << dist2[cur.X][cur.Y] + 1 ;
                return 0;
            }
            if(dist2[nx][ny] != -1 || board[nx][ny] == '#') continue;
            if(dist1[nx][ny] != -1 && dist1[nx][ny] <= dist2[cur.X][cur.Y]+1) continue;
            dist2[nx][ny] = dist2[cur.X][cur.Y] +1;
            Q2.push({nx,ny});
        }
    }
    cout << "impossible";
}
