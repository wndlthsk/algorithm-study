#include<bits/stdc++.h>
using namespace std;
int N;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N;
    int val[3];
    cin>>val[0]>>val[1]>>val[2]; //초기값 
    int mxdp_0=val[0]; int mxdp_1=val[1]; int mxdp_2=val[2];
    int mindp_0=val[0];int mindp_1=val[1]; int mindp_2=val[2];
    for(int i=1;i<N;i++)
    {
        int mxtmp_0=mxdp_0; int mxtmp_1=mxdp_1; int mxtmp_2=mxdp_2;
        int mintmp_0=mindp_0; int mintmp_1=mindp_1; int mintmp_2=mindp_2;
        //최대합
        cin>>val[0]>>val[1]>>val[2];
        mxdp_0=val[0]+max(mxtmp_0,mxtmp_1);
        mxdp_1=val[1]+max({mxtmp_0,mxtmp_1,mxtmp_2});
        mxdp_2=val[2]+max(mxtmp_1,mxtmp_2);
        //최소합
        mindp_0=val[0]+min(mintmp_0,mintmp_1);
        mindp_1=val[1]+min({mintmp_0,mintmp_1,mintmp_2});
        mindp_2=val[2]+min(mintmp_1,mintmp_2);
    }
    int mx_sum=max({mxdp_0,mxdp_1,mxdp_2});
    int min_sum=min({mindp_0,mindp_1,mindp_2});

    cout<<mx_sum<<' '<<min_sum;
    return 0;
}
