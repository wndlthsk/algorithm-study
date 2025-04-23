#include<bits/stdc++.h>
using namespace std;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin>>N;
    vector<int> v(N);
    int cur;
    stack<int> st;
    for(int i=0;i<N;i++) cin>>v[i];
    for(int i=N-1;i>=0;i--)
    {
        int cur = v[i];
        while(true)
        {
            if(st.empty())
            {
                v[i]=-1;
                st.push(cur);
                break;
            }
            else
            {
                if(st.top()>cur){
                    v[i]=st.top();
                    st.push(cur); 
                    break;
                }
                else st.pop();
               
            }
        }

    }
    for(auto i:v) cout<<i<<' ';
}
