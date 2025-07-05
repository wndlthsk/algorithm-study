#include<bits/stdc++.h>
using namespace std;
int k;
int S[13]; //S[0]~S[k-1]
int arr[6]; //뽑은 조합
//0<=p<=5인 p에 대해 arr[p]를 결정하는 함수.p==6이라면 arr[]를 출력
void func(int p,int start){
    if(p==6)
    {
        for(int i=0;i<6;i++) cout<<arr[i]<<' ';
        cout<<'\n';
        return;
    }
    for(int i=start;i<k;i++)
    {
        arr[p]=S[i];
        func(p+1,i+1);
    }

}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    while(true)
    {
    cin>>k;
    if(k==0) break;
    for(int i=0;i<k;i++) cin>>S[i];
    func(0,0);
    cout<<'\n';
    
    }
    return 0;

}
