//ㅈㄴ어렵다.더 강해져서 돌아오자
#include<bits/stdc++.h>
using namespace std;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin>>N;
    int arr[N];
    int dp[N][2];  //0->첫번째 전칸에서 현재칸 도달 최댓값 1->두번째 전칸에서 현재칸 도달 최댓값
    for(int i=0;i<N;i++) cin>>arr[i];

    dp[0][0]=arr[0];
    dp[0][1]=arr[0];

    dp[1][0]=arr[0]+arr[1];
    dp[1][1]=arr[1];
    /*
    dp[2][0]=dp[1][1]+arr[2];
    dp[2][1]=max(dp[0][0],dp[0][1])+arr[2];

    dp[3][0]=dp[2][1]+arr[3];
    dp[3][1]=max(dp[1][0],dp[1][1])+arr[3];
    */
    for(int i=2;i<N;i++){
        dp[i][0]=dp[i-1][1]+arr[i];
        dp[i][1]=max(dp[i-2][0],dp[i-2][1])+arr[i];
    }
    cout<<max(dp[N-1][0],dp[N-1][1]);
    return 0;
}
