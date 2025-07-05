#include<bits/stdc++.h>
using namespace std;
int N;
long long M;
long long result=2000000001;
vector<long long> arr;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    arr.resize(N);
    for(int i=0;i<N;i++) cin>>arr[i];
    sort(arr.begin(),arr.end());
    
    for(int i=0;i<N;i++){
        auto it=lower_bound(arr.begin(),arr.end(),arr[i]+M);
        if(it==arr.end()) continue;
        long long tmp=*it-arr[i];
        result=min(result,tmp);
    }

    cout<<result;
    return 0;
}
