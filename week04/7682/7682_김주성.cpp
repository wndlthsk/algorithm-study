#include<bits/stdc++.h>
using namespace std;

pair<int,int> tic_tac_to(string s){
    int x_line=0; int o_line=0;
    string board[3];
    for(int i=0;i<3;i++) board[i]=s.substr(3*i,3);
    //가로 확인
    for(int i=0;i<3;i++)
    {
        if(board[i][0]==board[i][1]&&board[i][1]==board[i][2]) 
        {
            if(board[i][1]=='X') x_line++;
            if(board[i][1]=='O') o_line++;
        }
    }
    //세로 확인
    for(int i=0;i<3;i++)
    {
        if(board[0][i]==board[1][i]&&board[1][i]==board[2][i]) 
        {
            if(board[1][i]=='X') x_line++;
            if(board[i][i]=='O') o_line++;
        }
    }
    //대각선 확인
    if(board[0][0]==board[1][1]&&board[1][1]==board[2][2])
    {
        if(board[1][1]=='X') x_line++;
        if(board[1][1]=='O') o_line++;
    }
    if(board[2][0]==board[1][1]&&board[1][1]==board[0][2])
    {
        if(board[1][1]=='X') x_line++;
        if(board[1][1]=='O') o_line++;
    }
    
    return {x_line,o_line};
}



int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    while(true){
        string s;
        cin>>s;
        if(s=="end") return 0;
        int x_num=0; int o_num=0;
        
        for(auto c:s)
        {
            if(c=='X') x_num++;
            if(c=='O') o_num++;
        }
        
        bool is_full;
        if(x_num+o_num==9) is_full=true;
        else is_full=false;

        if(is_full)
        {
            if(x_num==5&&o_num==4)
            {
                //x로 조건 만족하면 valid 아니면 invalid
                pair<int,int> cur = tic_tac_to(s);
                
                if(cur.first>=0&&cur.second==0)
                {
                    //valid
                    cout<<"valid"<<'\n';
                    continue;
                }
                else
                {
                    //invalid
                    cout<<"invalid"<<'\n';
                    continue;
                }
            }
            else
            {
                //invalid
                cout<<"invalid"<<'\n';
                continue;
            }
        }
        else
        {
            if(x_num==o_num)
            {
                //x로 조건 만족
                pair<int,int> cur = tic_tac_to(s);
                if(cur.first==0&&cur.second==1)
                {
                    //valid
                    cout<<"valid"<<'\n';
                    continue;
                }
                else
                {
                    //invalid
                    cout<<"invalid"<<'\n';
                    continue;
                }

            }
            else if(x_num==o_num+1)
            {
                //o로 조건 만족
                pair<int,int> cur = tic_tac_to(s);
                if(cur.first==1&&cur.second==0)
                {
                    //valid
                    cout<<"valid"<<'\n';
                    continue;
                }
                else
                {
                    //invalid
                    cout<<"invalid"<<'\n';
                    continue;
                }
            }
            else 
            {
                //invalid
                cout<<"invalid"<<'\n';
                continue;
            }
        }
    }
}
