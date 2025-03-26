#include<bits/stdc++.h>
using namespace std;
int N,M;
vector<int> arr; //숫자 N개 저장

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    arr.resize(N);
    for(int i=0;i<N;i++) cin>>arr[i];
    sort(arr.begin(),arr.end());
    cin>>M;
    while(M--){
        int target;
        cin>>target;
        cout<<upper_bound(arr.begin(),arr.end(),target)-lower_bound(arr.begin(),arr.end(),target);
        cout<<' ';
    }
    return 0;
}
