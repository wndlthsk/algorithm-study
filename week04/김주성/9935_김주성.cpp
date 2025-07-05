#include<bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    string s; //원본
    string f; //폭발
    cin>>s>>f;
    int siz = s.size();
    
    string result ="";
    for(int i=0;i<siz;i++)
    {
        result.push_back(s[i]);
        
        if(result.size()<f.size()) continue;
        if(s[i]!=f[f.size()-1]) continue;

        string temp=result.substr(result.size()-f.size(),f.size());
        
        if(temp!=f) continue;
        int len = f.size();
        while(len--) result.pop_back();  //f의 길이 만큼 pop

    }
    if(result.empty()) cout<<"FRULA";
    else cout<<result;

    return 0;
}
