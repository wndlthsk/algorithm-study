#include<bits/stdc++.h>
using namespace std;
int N; //전체 사람 수(N은 짝수,최대 20)
int min_dis=10000; //두팀간 능력치 합의 최소값(지속적으로 갱신됨)
int S[21][21]; //인덱스 1부터 다룰것
int team[11]; //N명중 선택된 N/2명을 저장할 임시 배열(백트래킹의 Decision space를 나타냄)
bool isused[21]; //1~N중 현재 space 상태에 이미 사용된 번호를 기록하기 위한 배열

//team[]을 구성하기 위한 백트래킹 함수,N/2개를 선택했다면 최소 차를 갱신하는 과정까지 포함
//k는 team에 현재까지 뽑힌 선수의 수 의미 
void func(int k)
{
    //절반을 뽑는게 목표
    if(k==N/2)
    {
        //team에 N/2 명이 뽑힌 경우
        int sum1=0;
        int sum2=0;
        int dis;
        for(int i=1;i<=N-1;i++)
            for(int j=i+1;j<=N;j++)
            {
                if(isused[i]==true&&isused[j]==true) sum1=sum1+S[i][j]+S[j][i];
                if(isused[i]==false&&isused[j]==false) sum2=sum2+S[i][j]+S[j][i];
            }
        if(sum1>=sum2) dis=sum1-sum2;
        else dis=sum2-sum1;
        min_dis=min(min_dis,dis);
        return; ////중요!!!!!!!!!!
    }
    //i는 1~N중 하나의 수 team은 그 수가 뽑히면 i를 team에 저장
    for(int i=1;i<=N;i++)
    {
        //현재 team에는 k명의 선수 존재,team[k+1]를 결정하는 과정임을 기억!
        if(isused[i]==false&&i>team[k])
        {
            isused[i]=true;
            //team[k+1]결정
            team[k+1]=i;
            func(k+1);
            //다시 team[k+1]를 결정
            isused[i]=false;
        }
    }

}
int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);
    //입력 
    cin>>N;
    for(int i=1;i<=N;i++)
        for(int j=1;j<=N;j++) cin>>S[i][j];
    team[0]=0;
    func(0);
    cout<<min_dis;
    return 0;
    
}
