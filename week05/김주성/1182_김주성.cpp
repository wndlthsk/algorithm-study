#include<bits/stdc++.h>
using namespace std;
int result;
int N;
int S;
vector<int> arr;
vector<int> sub_arr;
void back_track(int n,int st,int k)  //sub_arr N개 채우기.k개 채워져있을때 k+1번째 채우기(sub_arr[k] 채우기-sub_arr[n-1]까지)
{
    if(k==n)
    {
        int sum=0;
        for(int i=0;i<n;i++) sum+=sub_arr[i];
        if(sum==S) result++;
        return;
    }
    for(int i=st;i<N;i++) //arr(N)을 순회
    {
        sub_arr[k]=arr[i];
        back_track(n,i+1,k+1);
    }
}
/*
ex) arr[5]={2,4,6,8,10}
    sub_arr[n=3]={    }  
    back_track(n=3,st=0,k=0)->{2}
    back_track(n=3,st=1,k=1)->{2,4}
    back_track(n=3,st=2,k=2)->{2,4,6}
    back_track(n=3,st=3,k=3)->{2,4,6} k==3 return
    
    back_track(n=3,st=2,k=2)->{2,4,8}
    back_track(n=3,st=3,k=3)->{2,4,8} k==3 return

*/
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin>>N>>S;
    arr.resize(N);
    sub_arr.resize(N);
    for(int i=0;i<N;i++) cin>>arr[i];
    //백트래킹
    for(int i=1;i<=N;i++) back_track(i,0,0);
    
    cout<<result;
    return 0;
}

//1~N 개 채우는 백트래킹 수행->채울 때 마다 합 구하기
