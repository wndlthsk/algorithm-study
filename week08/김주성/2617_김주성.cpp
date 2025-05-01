#include<bits/stdc++.h>
using namespace std;
vector<int> adj_1[100];
vector<int> adj_2[100];
int result=0;
int N,M;
int bfs(int i,vector<int> adj[])
{
    vector<bool> vis(100);
    int num=0;
    queue<int> q;
    q.push(i);
    vis[i]=true;
    while(!q.empty())
    {
        
        int cur = q.front(); q.pop();
        for(int nxt:adj[cur])
        {
            if(vis[nxt]) continue;
            q.push(nxt);
            vis[nxt]=true;
            num++;
        }
        
    }
    return num;
    
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M; 
    int target = (N+1)/2;
    int hv; int light;
    for(int i=0;i<M;i++)
    {
        cin>>hv>>light;
        adj_1[hv].push_back(light);
        adj_2[light].push_back(hv);
    }
    for(int i=1;i<=N;i++)
    {
        
        //adj_1 에 대해 bfs 
        int depth_1=bfs(i,adj_1);

        //adj_2 에 대해 bfs
        int depth_2=bfs(i,adj_2);

        if(depth_1>=target||depth_2>=target) result++;
    } 

    cout<<result;

    return 0;
}
