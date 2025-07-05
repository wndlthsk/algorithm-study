#include<bits/stdc++.h>
using namespace std;
int display[100][100];
int N;

void zip(int n,int row,int col){

    int white=0; //white는 0
    int black=0; //black은 1
    //종료 조건.
    if(n==1)
    {
        if(display[row][col]==1) cout<<1;
        if(display[row][col]==0) cout<<0;

        return;
    }
    else//n>1
    {
        for(int i=row;i<row+n;i++)
            for(int j=col;j<col+n;j++)
            {
                if(display[i][j]==0) white++;
                if(display[i][j]==1) black++;
            }
        
            //n*n 행렬에 대해 전체가 1또는 0임->더 쪼갤 필요 x
        if(white==n*n)
        {
             cout<<0;
             return;
        }
        else if(black==n*n)
        {
             cout<<1;
             return;
        }
        else//n*n 행렬에 대해 전체가 1또는 0이아님->더 쪼개야됨.
        {
        cout<<'(';
        for(int i=row;i<row+n;i+=n/2)
            for(int j=col;j<col+n;j+=n/2)
            {
               
                zip(n/2,i,j);
               
               
            }
        cout<<')';
        }
    }
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin>>N;
    vector<string> arr(N);
    for(int i=0;i<N;i++) cin>>arr[i];
    
    
    for(int i=0;i<N;i++)
    {
        int idx=0;
        for(auto j:arr[i])
            display[i][idx++] = j-'0';
    }
            
    
    zip(N,0,0);
        
}
