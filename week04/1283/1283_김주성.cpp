#include<bits/stdc++.h>
using namespace std;
int N;
set<char> used;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    cin.ignore();
    while(N--)
    {
        
        bool print =false;
        string s;
        getline(cin, s);
        int siz=s.size();
        for(int i=0;i<siz;i++)
        {
            if(i==0)
            {
                if(used.count((char)toupper(s[i]))==0)
                {
                    //s[i]를 단축키로 출력 ,s[i]를 used에 insert
                    cout<<'['<<s[i]<<']';
                    for(int j=1;j<siz;j++) cout<<s[j];
                    cout<<'\n';

                    used.insert((char)toupper(s[i])); 
                    print=true;
                    break;
                }
            }
            if(i>=1&&s[i-1]==' ')
            {
                if(used.count((char)toupper(s[i]))==0)
                {
                    //s[i]를 단축키로 출력 ,s[i]를 used에 insert
                    for(int j=0;j<i;j++) cout<<s[j];
                    cout<<'['<<s[i]<<']';
                    for(int j=i+1;j<siz;j++) cout<<s[j];
                    cout<<'\n';

                    used.insert((char)toupper(s[i]));
                    print=true;
                    break;
                }
            }
        }
        if(print) continue; //다음 입력 진행

        for(int i=0;i<siz;i++)
        {
            if(s[i]!=' '&&used.count((char)toupper(s[i]))==0)
            {
                //s[i]를 단축키로 출력 ,s[i]를 used에 insert
                for(int j=0;j<i;j++) cout<<s[j];
                cout<<'['<<s[i]<<']';
                for(int j=i+1;j<siz;j++) cout<<s[j];
                cout<<'\n';
                used.insert((char)toupper(s[i]));
                print=true;
                break;
            }
        }
        if(print) continue; //다음 입력 진행
        //단축키를 지정할 수 없는 경우 그냥 출력
        for(auto c:s) cout<<c;
        cout<<'\n';
        
    }

    return 0;
}
