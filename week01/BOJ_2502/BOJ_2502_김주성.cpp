#include<bits/stdc++.h>
using namespace std;
int D,K;
vector<int> ddeock;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>D>>K;
    ddeock.resize(D);
    ddeock[0]=K;
    
    for(int i=K/2+1;i>=6;i++)
    {
        int day_3=0; int day_2=1; int day_1=2;
        ddeock[1]=i;
        while(day_1<=D-1)
        {

            ddeock[day_1]=ddeock[day_3]-ddeock[day_2];
            if(day_1==D-1)
            {
                if(ddeock[D-2]<ddeock[D-1]) break;
                cout<<ddeock[D-1]<<'\n'<<ddeock[D-2];
                return 0;
            }
            //day_1<D-1
            if(ddeock[day_2]<=ddeock[day_1]) break;
            if(ddeock[day_1]==1&&day_1<D-2) break;
            
            day_3++; day_2++; day_1++;
        }
    }
    
    return 0;
}
