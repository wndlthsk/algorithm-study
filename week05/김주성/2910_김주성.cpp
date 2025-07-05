#include<bits/stdc++.h>
using namespace std;
vector<long long> arr;
vector<long long> arr_ordered;
unordered_map<long long,int> order; //등장 순서
//현재 숫자의 개수 반환
int return_num(long long val){
    
    return upper_bound(arr_ordered.begin(),arr_ordered.end(),val)-lower_bound(arr_ordered.begin(),arr_ordered.end(),val);

}
bool cmp(long long a,long long b){
    if(return_num(a)!=return_num(b)) return return_num(a)>return_num(b);
    else return order[a]<order[b];
    //등장 순서 작은 순서대로
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N,C;
    cin>>N>>C;
    arr.resize(N);
    arr_ordered.resize(N);
    for(int i=0;i<N;i++)
    {
         cin>>arr[i];
         arr_ordered[i]=arr[i];
    }
    //return_num을 위해 arr_ordered 정렬
    sort(arr_ordered.begin(),arr_ordered.end());


    //순서 기록
    int num=1;
    order[arr[0]] =num;
    num+=1;
    for(int i=1;i<N;i++)
    {
        if(order.find(arr[i])!=order.end()) continue;//이미 갱신한 숫자면(해당 key가 존재하면 ) pass
        order[arr[i]]=num;
        num++;
    }
    //arr 정렬
    sort(arr.begin(),arr.end(),cmp);
    for(auto val:arr) cout<<val<<' ';

    return 0;
}
