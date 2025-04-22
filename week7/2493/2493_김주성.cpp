#include<bits/stdc++.h>
using namespace std;
int N;
unordered_map<int,int> idx;
stack<int> st;
vector<int> v;
vector<int> result;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    int num;
    for(int i=1;i<=N;i++)
    {
        cin>>num;
        v.push_back(num);
        idx[num]=i;
    }
    for(int i=0;i<N;i++)
    {
        int cur=v[i];
        while(true)
        {
            if(st.empty())
            {
                st.push(cur);
                cout<<0<<' ';
                break;
            }

            if(cur<st.top())
            {
                cout<<idx[st.top()]<<' ';
                st.push(cur);
                break;
            }
            else st.pop();
           
            
        }
    }
    
    

}

