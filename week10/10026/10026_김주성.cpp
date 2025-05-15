#include<bits/stdc++.h>
using namespace std;
int N;
int dx[4]={1,-1,0,0};
int dy[4]={0,0,1,-1};
int area; // 구역수

string board[102];
bool vis[102][102];
//bool vis_rgb[102][102];
void bfs(int i,int j)
{ //{i,j}좌표에 대해 BFS 돌기
    area++; //구역 한개 추가
    char color=board[i][j]; //'R' 'G' 'B'
    queue<pair<int,int>> q;
    q.push({i,j});
    vis[i][j]=true;
    while(!q.empty())
    {
        pair<int,int> cur=q.front(); q.pop();
        for(int dir=0;dir<4;dir++)
        {
            int nx=cur.first+dx[dir];
            int ny=cur.second+dy[dir];
            if(nx<0||ny<0||nx>=N||ny>=N) continue;
            if(board[nx][ny]!=color||vis[nx][ny]==true) continue;
            q.push({nx,ny});
            vis[nx][ny]=true;
        }
    }
}
// void bfs_rgb(int i,int j)
// {
    
// }
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i=0;i<N;i++) cin>>board[i];
    //일반인에 대해 구역수 구하기
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
        {
            if(vis[i][j]==true) continue;
            bfs(i,j); //(i,j)를 시작점으로 bfs 
        } 
    cout<<area<<' ';
    //함수 재사용 위해 area,vis[][]초기화
    area=0;
    for(int i=0;i<N;i++)
         for(int j=0;j<N;j++) vis[i][j]=false;
    //적록색약인의 board 설정
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++) if(board[i][j]=='G') board[i][j]='R';
    //적록색약인에 대해 구역수 구하기
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
        {
            if(vis[i][j]==true) continue;
            bfs(i,j); //(i,j)를 시작점으로 bfs 
        } 
    cout<<area;
    
    return 0;
        

}
