#include<bits/stdc++.h>
using namespace std;
int n;
vector<int> arr;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>n;
    arr.resize(n);
    for(int i=0;i<n;i++) cin>>arr[i];
    sort(arr.begin(),arr.end());
    int sum=arr[0];
    //각 사람의 대기 시간 구하기
    for(int i=1;i<n;i++)
    {
        arr[i]+=arr[i-1];
        sum+=arr[i];
    }
    cout<<sum;
    return 0;

}
