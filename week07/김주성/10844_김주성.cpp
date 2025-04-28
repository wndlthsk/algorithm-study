#include<bits/stdc++.h>
using namespace std;
#define ll long long
#define mod 1000000000
vector<ll> prev_num(10); //이전 단계에서 i로 끝나는 수의 개수 저장
ll result;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin>>N;
    if(N==1)
    {
        cout<<9;
        return 0;
    }
    prev_num={0,1,1,1,1,1,1,1,1,1}; //prev_num[i]:i로 끝나는 계단 수의 수(i:0~9)
    
    //한번의 반복에서 하는 동작:길이가 i인 계단 수 정보 prev_num에 갱신
    //길이가 N-1 인 계단 수 까지 
    for(int i=2;i<=N;i++)
    {
        //현재 정보 반영 임시 벡터
        vector<ll> cur(10);
        //이전 길이 계단 수 정보로 현재 길이 계단 수 정보 갱신
        for(int j=0;j<=9;j++)
        {
            if(j==9) cur[8] = (cur[8]+prev_num[j])%mod; // 9로 끝나는 계단수의 수 만큼 8로 끝나는 계단수 만들어짐
            else if(j==0) cur[1] = (cur[1]+prev_num[j])%mod;
            else
            {
                cur[j-1] = (cur[j-1]+prev_num[j])%mod;
                cur[j+1] = (cur[j+1]+prev_num[j])%mod;
            }
        }
        for(int j=0;j<=9;j++) prev_num[j]=cur[j];
    }
    for(int i=0;i<=9;i++)
    {
       result=(result+prev_num[i])%mod;
    }
        
    cout<<result%mod;
    return 0;

}
