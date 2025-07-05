#include<bits/stdc++.h>
using namespace std;
int n;
int result;
int arr[100002];
int dp[100002];
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>n;
    for(int i=1;i<=n;i++) cin>>arr[i];
    dp[1]=arr[1];
    result=dp[1]; //현재까지의 최댓값
    for(int i=2;i<=n;i++){ 
        dp[i]=max(arr[i],arr[i]+dp[i-1]);   
        result=max(result,dp[i]);
    }
    
    cout<<result;
    return 0;
}
