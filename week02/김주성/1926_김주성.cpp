#include<bits/stdc++.h>
using namespace std;
int num=0; //그림의 개수
int mx=0; //가장큰 그림 크기

int board[502][502];
bool vis[502][502];    //자동으로 0으로 초기화.일단 크게 잡아놓고 n행 m열에 대해서만 다룰것임.

int main(void){
    ios::sync_with_stdio(0);
    cin.tie(0); 
    //그림 크기 입력받기.
    int n,m;
    cin>>n;
    cin>>m;
    //그림 모양 입력 받기.
    //int board[n][m];  ->>잘못된 방법,
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<m;j++)
        {
            cin>>board[i][j];
        }
    }
    //bool vis[n][m]={0}; //잘못된 방법
    //queue<pair<int,int>> Q ;//탐색을 위한 좌표를 담을 큐 선언.
    int dx[4]={1,0,-1,0};
    int dy[4]={0,1,0,-1};
    
    //BFS의 시작점을 찾는 과정
    for(int i=0;i<n;i++)
        for(int j=0;j<m;j++)
        {
            //시작점이 될 수없다면 다음 좌표를 탐색
            if(board[i][j]==0||vis[i][j]) continue;
            queue<pair<int,int>> Q ;
            int siz=1; //해당 시작점을 포함하는 그림의 크기.(초기값은 시작점만 포함한 1)
            num++; //시작점의 개수=그림의 개수.
            //(n,m)은 시작점이 되고 여기서부터 BFS 알고리즘 시작.
            Q.push({i,j});
            vis[i][j]=1;  
            pair<int,int> cur;
            while(!Q.empty())
            {
                cur =Q.front(); Q.pop();  //1.현재 front 꺼내서 cur에 담기.
                for(int dir=0;dir<4;dir++) //2.꺼낸 front 주변 좌표 탐색하기
                {
                    int nx =cur.first +dx[dir];
                    int ny =cur.second +dy[dir];
                    if(nx<0||ny<0||nx>=n||ny>=m) continue;
                    if(vis[nx][ny]||board[nx][ny]==0) continue;

                    vis[nx][ny]=1; //3.미방문칸 찾아 방문하고 큐에 담기
                    siz++;
                    Q.push({nx,ny});  
                    
                }
            }
            mx=max(mx,siz);

        }
       
    

    cout<<num<<'\n';
    cout<<mx;
    
    return 0;
   


}
