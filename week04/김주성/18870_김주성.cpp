#include<bits/stdc++.h>
using namespace std;
int N;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    vector<int> arr(N);
    vector<int> sorted_arr(N);
    for(int i=0;i<N;i++)
    {
         cin>>arr[i];
         sorted_arr[i]=arr[i];
    }
    sort(sorted_arr.begin(),sorted_arr.end());
    //정렬된 배열에서 중복 제거 ->unique_arr
    vector<int> unique_arr;
    unique_arr.push_back(sorted_arr[0]);
    int last=sorted_arr[0];
    for(int i=1;i<N;i++)
    {
        if(sorted_arr[i]==last) continue; 
        unique_arr.push_back(sorted_arr[i]);
        last=sorted_arr[i];

    }
    for(int i=0;i<N;i++)
    {
        int target=arr[i];
        auto idx=lower_bound(unique_arr.begin(),unique_arr.end(),target);
        cout<<idx-unique_arr.begin()<<' ';

    }
    return 0;
}
