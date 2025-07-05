#include<bits/stdc++.h>
using namespace std;
vector<int> adj[51]; //인덱스 1부터 N까지 (N<=50)
int N;
int min_dis=100000;  //회장 후보 점수
int dis[51]; //mas_dis 함수에서 각 노드 방문여부저장
int result[51]; //모든 회원 점수 저장
//회원 번호 k에 대해 다른 모든 회원과의 거리 중 최댓값(점수를 의미)
//가령 모든 회원이 거리 1이라면 점수 1
int max_dis(int k)
{
    int mx=0;

    memset(dis,-1,sizeof(dis));
    //bfs
    queue<int> q;
    q.push(k);
    dis[k]=0;
    while(!q.empty())
    {
        int cur =q.front(); q.pop();
        //cur의 정점 확인
        for(int nxt:adj[cur])
        {
            if(dis[nxt]!=-1) continue;
            //방문된 적 없는 인접 노드
            q.push(nxt);
            dis[nxt]=dis[cur]+1;
            mx=max(dis[nxt],mx);
        }
        
    }
    return mx;  //k 노드의 점수 반환
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N; 
    //그래프 갱신
    while(true)
    {
        int p,q;
        cin>>p>>q;
        if(p==-1&&q==-1) break; //입력 종료 조건
        adj[p].push_back(q);
        adj[q].push_back(p);
    }
    //회장 후보 점수 
    for(int i=1;i<=N;i++)
    {
        result[i]=max_dis(i); //점수 저장
        min_dis = min(min_dis,result[i]); //최소 점수 갱신
        
    }
    //
    vector<int> v; //회장 후보 저장
    int num=0; //회장 후보 수
    for(int i=1;i<=N;i++)
    {
        if(result[i]==min_dis) //최소 점수면 회장 후보
        {
             num++;
             v.push_back(i);

        }
    }

    cout<<min_dis<<' '<<num<<'\n';
    for(auto i:v) cout<<i<<' ';

    return 0;
}
