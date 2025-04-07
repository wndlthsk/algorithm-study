#include<bits/stdc++.h>
using namespace std;
vector<int> adj[501];
int result=0;
int dist[501]; //각 정점의 1부터의 거리
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    memset(dist,-1,sizeof(dist));
    int n,m;
    cin>>n>>m;
    //그래프 입력
    for(int i=0;i<m;i++)
    {
        int p,q;
        cin>>p>>q;
        adj[p].push_back(q);
        adj[q].push_back(p);
    }
    //adj 각 행 정렬
    for(int i=1;i<=n;i++) sort(adj[i].begin(),adj[i].end());

    queue<int> q;
    q.push(1);
    dist[1]=0;
    while(!q.empty())
    {
        int cur = q.front(); q.pop();
        for(int nxt:adj[cur])
        {
            if(dist[nxt]!=-1) continue;
            dist[nxt]=dist[cur]+1;
            q.push(nxt);
            if(dist[nxt]==1||dist[nxt]==2) result++;
        }

    }

    cout<<result;
    return 0;
}
