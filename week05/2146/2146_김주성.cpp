#include<bits/stdc++.h>
using namespace std;
int N;
int board[101][101];
bool vis[101][101];
//bool vis[101][101];
int island =2;
int result =10000000;
vector<pair<int,int>> side;
int dx[4]={1,-1,0,0};
int dy[4]={0,0,1,-1};
int find_other(int,int);
void bfs(int i,int j){
    if(board[i][j]!=1) return;
    //새로운 섬 시작점 발견
    queue<pair<int,int>> q;
    q.push({i,j});
    board[i][j]=island; //2
    while(!q.empty())
    {
        pair<int,int> cur = q.front(); q.pop();
        for(int dir=0;dir<4;dir++)
        {
            int nx =cur.first+dx[dir];
            int ny =cur.second+dy[dir];
            if(nx<0||ny<0||nx>=N||ny>=N) continue;
            if(board[nx][ny]==0) side.push_back({cur.first,cur.second});
            if(board[nx][ny]!=1) continue;
            q.push({nx,ny});
            board[nx][ny]=island; 
        }
    }
    island++; //섬하나 갱신 후 번호추가
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
   
    cin>>N;
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++) cin>>board[i][j];

    
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++) bfs(i,j);
        
   

    //가장 자리를 시작점으로 bfs -> 자신과 다른 숫자 만나면 거리 반환!
    for(int i=0;i<side.size();i++)
    {
        pair<int,int> c =side[i];
        int len=find_other(c.first,c.second);
        result=min(result,len);
    }
    cout<<result;
    return 0;
    
}

int find_other(int m,int n)
{
    int cur_num=board[m][n]; //현재 섬번호
    memset(vis,0,sizeof(vis)); //방문 배열 초기화 
    //bfs 시작
    int len=0;
    queue<pair<int,int>> q;
    q.push({m,n});
    
    while(!q.empty())
    {
        int q_siz=q.size();
        for(int i=0;i<q_siz;i++)
        {
            pair<int,int> cur =q.front(); q.pop();
            for(int dir=0;dir<4;dir++)
            {
                int nx=cur.first+dx[dir];
                int ny=cur.second+dy[dir];
                if(nx<0||ny<0||nx>=N||ny>=N) continue;
                if(vis[nx][ny]==true) continue; //방문 한 바다 칸 pass
                
                if(board[nx][ny]!=0&&board[nx][ny]!=cur_num) return len; //다른 섬칸 만나면 현재 경로 길이 반환
                if(board[nx][ny]==cur_num) continue; //현재 섬이면 pass
                //바다 칸 방문
                q.push({nx,ny});
                vis[nx][ny]=true;
            }
            //같은 거리 모든 방향 진행후 len 증가
           
        }
        len++;
    }
    return result; //반환 못하면 이전 result반환
}










/*
1.섬마다 숫자 다르게 표시
2.가장 자리 큐에 다 넣기
3.가장 자리를 시작점으로 수행.만약 시작 점과 다른 숫자라면 거리 반환
4.최솟값 갱신
*/

/*
1이면 방문 가능!
0이거나 2이상이면 방문 불가
*/
