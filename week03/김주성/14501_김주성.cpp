//dp[i]: i번째 날부터 퇴사일까지 벌 수 있는 최대 이익
/*
dp[7]=0 ,dp[6]=0 ,dp[5]=p[5] ,dp[4]=p[4]+dp[5] ,dp[3]=p[3]+
dp[i]=max(p[3]+dp[e[3]],dp[4])
현재 날짜를 포함할지 ,포함안할지->포함안하면 dp는 다음날짜~퇴사일까지 최대이익
*/
#include<bits/stdc++.h>
using namespace std;
int N;
int T[16]; //인덱스 1부터 시작
int P[16];
int E[16];
int dp[16];
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    for(int i=1;i<=N;i++){
        cin>>T[i]>>P[i];
        E[i]=T[i]+i-1; //i일 상담시 상담종료일
    }
    if(T[N]==1) dp[N]=P[N];
    else dp[N]=0;

    for(int i=N-1;i>=1;i--){
        if(E[i]>N) dp[i]=dp[i+1]; //i일 상담 종료가 스케줄 벗어나면 일정에 포함 못시킴
        else dp[i]=max(P[i]+dp[E[i]+1],dp[i+1]);
    }

    cout<<dp[1];
    return 0;
}
