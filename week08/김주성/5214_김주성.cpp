#include<bits/stdc++.h>
using namespace std;
int vis[100001];
vector<int> adj[100001]; //인덱스 1부터
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    //하이퍼 튜브->역 K개를 서로 연결
    //역의 수, 연결하는 역 수, 튜브 수
    int N,K,M;
    cin>>N>>K>>M;
    for(int i=0;i<M;i++)
    {
        vector<int> v(K); 
        for(int i=0;i<K;i++) cin>>v[i];
        for(int i=0;i<K-1;i++)
            for(int j=i+1;j<K;j++)
            {
                if(!binary_search(adj[v[i]].begin(),adj[v[i]].end(),v[j])) adj[v[i]].push_back(v[j]);
                if(!binary_search(adj[v[j]].begin(),adj[v[j]].end(),v[i])) adj[v[j]].push_back(v[i]);

                sort(adj[v[i]].begin(),adj[v[i]].end());
                sort(adj[v[j]].begin(),adj[v[j]].end());
               
            }
        
    }
    //1번에서 N번 가는데 방문하는 역 개수 최소값
    //BFS
    memset(vis,-1,sizeof(vis));
    queue<int> q;
    q.push(1);
    vis[1]=1;
    while(!q.empty())
    {
        int cur = q.front(); q.pop();
        for(int nxt:adj[cur])
        {    
            if(vis[nxt]>0) continue;
            //종료 조건
            if(nxt==N)
            {
                cout<<vis[cur]+1;
                return 0;
            }
            q.push(nxt);
            vis[nxt]=vis[cur]+1;
        }
    }

    cout<<-1;
    return 0;
}
