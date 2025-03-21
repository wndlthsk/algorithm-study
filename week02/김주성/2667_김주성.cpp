#include<bits/stdc++.h>
using namespace std;
int dx[4]={1,-1,0,0};
int dy[4]={0,0,1,-1};
int N;
vector<int> num_house; //각 단지의 집의 수 저장
int n; //단지수
string board[25];
int bfs(int i,int j)
{
    queue<pair<int,int>> q;
    q.push({i,j}); board[i][j]='v'; //visit
    int siz=1;
    while(!q.empty()) 
    {
        pair<int,int> cur=q.front(); q.pop();
        for(int dir=0;dir<4;dir++) //cur의 주변점 방문
        {
            int nx=cur.first+dx[dir];
            int ny=cur.second+dy[dir];
            if(nx<0||ny<0||nx>=N||ny>=N) continue;
            if(board[nx][ny]=='v'||board[nx][ny]=='0') continue;
            board[nx][ny]='v';
            siz++;
            q.push({nx,ny});
        }

    }
    return siz;
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i=0;i<N;i++) cin>>board[i];
    for(int i=0;i<N;i++)
        for(int j=0;j<N;j++)
        {
            if(board[i][j]=='1')
            { 
                num_house.push_back(bfs(i,j));
                n++;
            }
            
        }
    cout<<n<<'\n';
    sort(num_house.begin(),num_house.end());
    for(int i=0;i<n;i++) cout<<num_house[i]<<'\n';
    
    return 0;
    }
