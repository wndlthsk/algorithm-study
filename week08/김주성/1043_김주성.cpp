#include<bits/stdc++.h>
using namespace std;
int result=0;
int adj[51][51]; //1~N 까지 인덱스 다룸
int N,M;
int T;
vector<int> truth; //진실아는 사람+연결된 사람
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M; //사람 수,파티 수
    cin>>T;
    vector<int> know(T); //진실아는 사람 번호 저장
    vector<int> party[51]; //파티장 저장
    for(int i=0;i<T;i++) 
    {
        cin>>know[i];
        truth.push_back(know[i]);
    }
    
    //그래프 만들기,파티의 첫번째 요소를 부모로 삼기
    for(int i=0;i<M;i++)
    {
        int num;
        cin>>num;
        int fir;
        cin>>fir;
        party[i].push_back(fir);
        for(int j=1;j<num;j++)
        {
            int node;
            cin>>node;
            party[i].push_back(node);
            adj[fir][node]=1;
            adj[node][fir]=1;
        }
    }
    //연결된 사람 확인
    
    for(int i=0;i<T;i++)
    {
        vector<bool> vis(N+1);
        queue<int> q;
        q.push(know[i]);
        vis[i]=true;
        while(!q.empty())
        {
            int cur = q.front(); q.pop();
            for(int j=1;j<=N;j++)
            {
                if(adj[cur][j]==0) continue;
                if(vis[j]) continue;
                q.push(j);
                vis[j]=true;
                truth.push_back(j);
            }
        }
    }
    sort(truth.begin(),truth.end());
    //파티 가능 여부 확인
    for(int i=0;i<M;i++)
    {
        bool canspeak = true;
        for(int a:party[i])
        { 
            if(binary_search(truth.begin(),truth.end(),a))
            {
                canspeak=false;
                break;
            }
        
        }
        if(canspeak) result++;
    }


    

    cout<<result;
    return 0;
}
