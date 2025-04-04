#include<bits/stdc++.h>
using namespace std;
int arr[5][8]; //톱니 종류는 인덱스 1번 부터 다룸
string input[5];

//n번 톱니 dir 방향 회전
void rotate(int n,int dir){
    if(dir==1)
    {
        //시계 회전 // ex) 1010111 1->  1 1010111h
        int tmp1=arr[n][7];
        for(int i=6;i>=0;i--)
        {
            arr[n][i+1]=arr[n][i];
        }
        arr[n][0]=tmp1;
        
    }
    else 
    {
        //반시계 회전 // ex) 10101111->  0101111 1
        int tmp2=arr[n][0];
        for(int i=0;i<=6;i++)
        {
            arr[n][i]=arr[n][i+1];
        }
        arr[n][7]=tmp2;
    }
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    //톱니 상태 입력
    for(int i=1;i<=4;i++) cin>>input[i];
    for(int i=1;i<=4;i++)
        for(int j=0;j<8;j++)
        {
            arr[i][j]=input[i][j]-'0';
        }

    //회전 횟수 입력
    int K;
    cin>>K;
    while(K--){
        int n;
        int dir; //인덱스 1부터 
        cin>>n>>dir;
        int n_dir[5];
        if(n==1||n==3)
        {
            n_dir[1]=dir;
            n_dir[2]=(-1)*dir;
            n_dir[3]=dir;
            n_dir[4]=(-1)*dir;
        }
        else //n==2 or n==4
        {
            n_dir[1]=(-1)*dir;
            n_dir[2]=dir;
            n_dir[3]=(-1)*dir;
            n_dir[4]=dir;
        }
        
        

        bool can_rotate[5]; //인덱스 1부터
        
        memset(can_rotate,0,sizeof(can_rotate));
        if(n==1) //1번 회전
        {
            can_rotate[1]=true;
            if(arr[1][2]!=arr[2][6])
            { 
                can_rotate[2]=true;
                if(arr[2][2]!=arr[3][6])
                {
                    can_rotate[3]=true;
                    if(arr[3][2]!=arr[4][6]) can_rotate[4]=true;
                }
            }
            
        }
        else if(n==2) //2번 회전
        {
            can_rotate[2]=true;
            if(arr[1][2]!=arr[2][6]) can_rotate[1]=true;
            if(arr[2][2]!=arr[3][6])
            {
                can_rotate[3]=true;
                if(arr[3][2]!=arr[4][6]) can_rotate[4]=true;
            }

        }
        else if(n==3) //3번 회전
        {
            can_rotate[3]=true;
            if(arr[3][2]!=arr[4][6]) can_rotate[4]=true;
            if(arr[2][2]!=arr[3][6])
            {
                can_rotate[2]=true;
                if(arr[1][2]!=arr[2][6]) can_rotate[1]=true;
            }

        }
        else //4번 회전
        {
            can_rotate[4]=true;
            if(arr[3][2]!=arr[4][6])
            { 
                can_rotate[3]=true;
                if(arr[2][2]!=arr[3][6])
                {
                    can_rotate[2]=true;
                    if(arr[1][2]!=arr[2][6]) can_rotate[1]=true;
                }
            }
        }
        //회전
        for(int i=1;i<=4;i++)
        {
            if(can_rotate[i]) rotate(i,n_dir[i]);
        }
        
    }

    //점수 측정
    int result=0;
    for(int i=1;i<=4;i++)
    {
        if(arr[i][0]==1) result+=pow(2,i-1);
    }
    cout<<result;

    return 0;

}
