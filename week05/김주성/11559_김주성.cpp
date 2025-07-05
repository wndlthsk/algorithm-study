#include<bits/stdc++.h>
using namespace std;
char field[12][6];
bool vis[12][6];
int dx[4]={1,-1,0,0};
int dy[4]={0,0,1,-1};
int result;
//삭제 가능 여부 판단 함수
int bfs(int i,int j){
    int siz=0 ; //현재 면적
    
    queue<pair<int,int>> q;
    q.push({i,j});
    vis[i][j]=true;
    siz++;
    while(!q.empty())
    {
        pair<int,int> cur = q.front(); q.pop();
        for(int dir=0;dir<4;dir++)
        {
            int nx=cur.first+dx[dir];
            int ny=cur.second+dy[dir];
            if(nx<0||ny<0||nx>=12||ny>=6) continue;
            if(vis[nx][ny]==true||field[nx][ny]!=field[cur.first][cur.second]) continue;
            //주변 칸 중 같은 색깔의 칸 만 방문
            q.push({nx,ny});
            vis[nx][ny]=true;
            siz++;
        }
    }
    return siz;
}
//(i,j)와 같은 색깔 주변 칸 삭제
void puyo(int i,int j){
    queue<pair<int,int>> q;
    char cur_cor=field[i][j]; //현재 색깔
    q.push({i,j});
    field[i][j]='.';
    while(!q.empty())
    {
        pair<int,int> cur = q.front(); q.pop();
        for(int dir=0;dir<4;dir++)
        {
            int nx=cur.first+dx[dir];
            int ny=cur.second+dy[dir];
            if(nx<0||ny<0||nx>=12||ny>=6) continue;
            if(field[nx][ny]!=cur_cor) continue;
            q.push({nx,ny});
            field[nx][ny]='.';
        }
    }
}


//현재 레벨 처리 함수
int boom(){
    memset(vis,0,sizeof(field)); //방문 배열 초기화
    int num_block=0; //현재 레벨에서 처리된 블럭 수
    
    for(int i=0;i<12;i++)
        for(int j=0;j<6;j++)
        {
            if(field[i][j]=='.') continue;
            if(vis[i][j]) continue;
            if(bfs(i,j)<4) continue;
            //(i,j) 시작점 면적 삭제
            puyo(i,j);
            num_block++;
        }

    return num_block;
}

void move_down(){
    vector<char> v[6];
    for(int i=0;i<6;i++)
        for(int j=0;j<12;j++) if(field[j][i]!='.') v[i].push_back(field[j][i]);
    memset(field,'.',sizeof(field));

    for(int i=0;i<6;i++)
    {
        int idx=0;
        for(int j=12-v[i].size();j<12;j++)
        {
            field[j][i]=v[i][idx];
            idx++;
        }
    }
        
    
}
// v={ } {yy} {gyy} {gg} {g} { }

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    //필드 입력 받기
    for(int i=0;i<12;i++)
        for(int j=0;j<6;j++) cin>>field[i][j];
        
    while(true)
    {
        if(boom()==0) break; //처리된 블럭이 없으면 break!
        result++; //현재 레벨 처리되면 연쇄 1 증가
        move_down(); //다음 레벨 처리를 위해 뿌요 아래로 이동
    }
    
    cout<<result;

   
    return 0;

}
