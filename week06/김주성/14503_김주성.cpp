#include<bits/stdc++.h>
using namespace std;
int N,M;
int board[51][51]; 
bool cleaned[51][51]; //청소여부 true=청소됨  flase=청소안됨
bool search_near(int,int); //주변 4칸 중 청소되지 않은 빈칸 확인
int dn[4]={-1,0,1,0};
int dm[4]={0,1,0,-1};    //{0,1,2,3}={북,동,남,서}
int result=0; //청소한 칸 개수

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    pair<int,int> cur;
    cin>>cur.first>>cur.second;
    int cur_dir; //현재 청소기의 방향  {0,1,2,3}={북,동,남,서}
    cin>>cur_dir;
    //방 구조 입력
    for(int i=0;i<N;i++)
        for(int j=0;j<M;j++) cin>>board[i][j];
    
    
    while(true){
        //1번 조건
        if(cleaned[cur.first][cur.second]==false)
        {
            cleaned[cur.first][cur.second]=true;
            result++;
        }
        //2번 조건
        if(!search_near(cur.first,cur.second))
        {
            //후진
            cur.first=cur.first-dn[cur_dir];
            cur.second=cur.second-dm[cur_dir];
            //현재방향 후진 결과, 벽일 경우 작동중지
            if(cur.first<0||cur.second<0||cur.first>=N||cur.second>=M) break;
            if(board[cur.first][cur.second]==1) break;
            //후진 가능한 경우 1번으로 돌아가기
            continue;
        }
        else //3번 조건
        {
            //반시계 방향 회전 
            if(cur_dir==0) cur_dir=3;
            else if(cur_dir==1) cur_dir=0;
            else if(cur_dir==2) cur_dir=1;
            else cur_dir=2;
            //보는 방향 기준 한칸 앞 청소x빈칸일 경우 전진(cur 업데이트)-ok
            int nx=cur.first+dn[cur_dir];
            int ny=cur.second+dm[cur_dir];
            if(nx<0||ny<0||nx>=N||ny>=M) continue; //벽일 경우 진행x(방향만 전환됨)
            if(board[nx][ny]==1) continue; //벽일 경우 진행x(방향만 전환됨)
            if(cleaned[nx][ny]==true) continue; //벽이아닌데 청소된 경우 진행x
            cur.first=nx;
            cur.second=ny;  //빈칸이면서 청소되지 않음->한칸 앞 진행(전진 결과 cur에 반영)
            //1번으로-ok
            continue;
        }
    }

    cout<<result;
    return 0;
    
    
}
//하나라도 청소되지 않은 빈칸있으면 true반환 하나도 없으면 flase반환
bool search_near(int i,int j){
    bool exist = false; 
    
    for(int dir=0;dir<4;dir++)
    {
        int nx=i+dn[dir];
        int ny=j+dm[dir];
        if(nx<0||ny<0||nx>=N||ny>=M) continue; //벽인 경우 pass
        if(board[nx][ny]==1) continue;
        if(cleaned[nx][ny]==true) continue;
        exist=true; //벽아니면서 청소안된 칸 발견
    }

    return exist;
}
