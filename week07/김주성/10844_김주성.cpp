#include<bits/stdc++.h>
using namespace std;
vector<int> prev_num(10); //이전 단계에서 i로 끝나는 수의 개수 저장
int cur_tot;

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin>>N;
    vector<int> dp(N);
    //N==1 일때
    if(N==1){
        cout<<9;
        return 0;
    }
    prev_num={0,1,1,1,1,1,1,1,1,1};
    int cur_tot=0;
    for(int i=2;i<=N;i++)
    {
        cur_tot=0;
        vector<int> cur_num(10);
        fill(cur_num.begin(),cur_num.end(),0);
        for(int j=0;j<=9;j++)
        {
            if(j==9) cur_tot+=prev_num[9];
            else if(j==0) cur_tot+=prev_num[0];
            else cur_tot+=2*prev_num[j];
        }
        for(int j=0;j<=9;j++)
        {
            if(j==9) cur_num[8]+=prev_num[9];
            else if(j==0) cur_num[1]+=prev_num[0];
            else
            {
                cur_num[j-1]+=prev_num[j];
                cur_num[j+1]+=prev_num[j];
                
            }
        }
        for(int i=0;i<=9;i++) prev_num[i]=cur_num[i];
    }
        

    

    cout<<cur_tot;

}
