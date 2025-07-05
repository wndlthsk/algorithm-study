#include<bits/stdc++.h>
using namespace std;
int adj[1001][1001];//인덱스 0부터
int N,M;
int cal_dis(int st,int en)
{
    //st로부터의 거리
    int dis[1001];
    memset(dis,-1,sizeof(dis));
    //bfs
    queue<int> q;
    q.push(st);
    dis[st]=0;
    while(!q.empty())
    {
        int cur = q.front(); q.pop();
        for(int nxt=1;nxt<=N;nxt++)
        {
            if(adj[cur][nxt]==0) continue;
            if(dis[nxt]!=-1) continue;
            q.push(nxt);
            dis[nxt]=dis[cur]+adj[cur][nxt];
        }
    }
    return dis[en];
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    for(int i=0;i<N-1;i++)
    {
        int n1,n2,dis;
        cin>>n1>>n2>>dis;
        adj[n1][n2]=dis;
        adj[n2][n1]=dis;
    }
    for(int i=0;i<M;i++)
    {
        int st,en;
        cin>>st>>en;
        cout<<cal_dis(st,en)<<'\n';
    }
    return 0;
    
    

}

/*
1~N 까지의 노드 존재
간선 M개 존재 거리 존재
*/
