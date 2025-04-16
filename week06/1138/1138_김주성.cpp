#include<bits/stdc++.h>
using namespace std;
int N;


int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    cin>>N;
    vector<int> v(N+1);
    vector<int> result(N+1);
    fill(result.begin(),result.end(),-1);

    
    for(int i=1;i<=N;i++)
    {
        cin>>v[i]; //6 1 1 1 2 0 0
        int num = 0;
        for(int j=1;j<=N;j++)
        {
            if(result[j]==-1) num++;
            if(num==v[i]+1){
                 result[j]=i; 
                 break;
            }
            //가령 v[2]=1이라면 result에서 두번째 -1 이 저장된 칸에 2를 저장
            //v[4]=0이라면 첫번째 -1에 저장
        }
    }
    /*

    6 2 3 4 -1 5 1
    v[6]+1==1  num=1
    */
    


    
    for(int i=1;i<=N;i++) cout<<result[i]<<' ';
    return 0;
    

}

/*
   v[i]가 3이라면 result에서 -1이 4번째로 나오는 인덱스에 i저장
   v[i]가 0이라면 result에서 첫번째 -1이 나오는 칸에 i저장


   
*/

