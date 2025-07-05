#include<string>
#include<iostream>
#include<vector>
#include<algorithm>
#include<tuple>
#include<queue>
using namespace std;
int dx[6]={1,-1,0,0,0,0};
int dy[6]={0,0,1,-1,0,0};
int dz[6]={0,0,0,0,1,-1};
int main(){
    while(true)
    {
        int x=0;
        queue<tuple<int,int,int>> q;
        bool printed=false;
        int L,R,C;
        cin>>L>>R>>C;
        if(L==0&&R==0&&C==0) return 0;
        ////i,j,k->z,x,y 
        vector<vector<string>> tower(L,vector<string>(R));
        for(int i=0;i<L;i++)
        {
            for(int j=0;j<R;j++)
            {
                cin>>tower[i][j];
                for(int k=0;k<C;k++)
                {
                    if(tower[i][j][k]=='S') 
                    { 
                        q.push({i,j,k});
                        tower[i][j][k]='#'; //방문
                }
                }
            }
            
        }
        //3차원 bfs
        while(!q.empty())
        {
            int siz=q.size();
            for(int i=0;i<siz;i++)
            {
                tuple<int,int,int> cur=q.front(); q.pop();
                for(int dir=0;dir<6;dir++)
                {
                    int nz=get<0>(cur)+dz[dir];
                    int nx=get<1>(cur)+dx[dir];
                    int ny=get<2>(cur)+dy[dir];
                    if(nz<0||nx<0||ny<0||nz>=L||nx>=R||ny>=C) continue;
                    if(tower[nz][nx][ny]=='#') continue;
                    //(nz,nx,ny) 방문 가능
                    //탈출 조건
                    if(tower[nz][nx][ny]=='E')
                    {
                    cout<<"Escaped in "<<x+1<<" minute(s)."<<'\n'; 
                    printed=true;
                    break;
                    }
                    tower[nz][nx][ny]='#'; //방문 표시
                    q.push({nz,nx,ny});
                }
                if(printed==true) break;
            }
            if(printed==true) break;
            x++;
        }
        if(printed==true) continue;
        if(printed==false) cout<<"Trapped!"<<'\n';
    
    }
}
