#include<bits/stdc++.h>
using namespace std;
int N;
int cost[1001][1001];
int result;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin>>N;
    //행->집의 번호 ,열->R,G,B (0열 1)
    for(int i=0;i<N;i++)
        for(int j=0;j<3;j++) cin>>cost[i][j];
    //N번째집의 색이 각각 R,G,B인 케이스로 분리(DP벡터는 편의를 위해 인덱스1부터 시작)
    vector<int> DP_R(N+1);
    vector<int> DP_G(N+1);
    vector<int> DP_B(N+1);
    //각 케이스의 DP를 N항까지 채우기
    //첫번째집을 각각 R,G,B로 칠하는 데 드는 비용
    DP_R[1]=cost[0][0];
    DP_G[1]=cost[0][1];
    DP_B[1]=cost[0][2];
    //DP_X[N]까지 갱신
    for(int i=2;i<=N;i++)
    {
        DP_R[i]=min(DP_G[i-1],DP_B[i-1])+cost[i-1][0];
        DP_G[i]=min(DP_R[i-1],DP_B[i-1])+cost[i-1][1];
        DP_B[i]=min(DP_G[i-1],DP_R[i-1])+cost[i-1][2];
    }


    result=min({DP_R[N],DP_G[N],DP_B[N]});
    cout<<result;
}
