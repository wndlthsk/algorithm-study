#include<bits/stdc++.h>
using namespace std;
int N,M;
int result=100000;
int city[51][51];
vector<pair<int,int>> h;
vector<pair<int,int>> c; 
vector<int> selected; 

int len_house(int k){

    int h_len=100000;  
    int h_x=h[k].first;
    int h_y=h[k].second;
    for(int i=0;i<M;i++)
    {
        int c_x=c[selected[i]].first;
        int c_y=c[selected[i]].second;
        int len=abs(h_x-c_x)+abs(h_y-c_y);
        h_len=min(h_len,len);
    }
    return h_len;
}


void func(int k,int start){
    if(k==M){
        //선택된 selected에 대해 치킨 거리 city_len 구하기
        int city_len=0;
        for(int i=0;i<h.size();i++) //모든 집에대해
        {
            city_len+=len_house(i); //도시의 치킨거리=각 집에 대한 치킨거리의 합(각 집의 치킨거리는 집에서 가장 가까운 치킨집까지의 거리)
            //result=min(result,city_len); //가능한 M개의 조합에 대해 city_len의 최솟값.
        }
        result=min(result,city_len); //가능한 M개의 조합에 대해 city_len의 최솟값.
        return;
    }
    for(int i=start;i<c.size();i++)
    {
        selected[k]=i;
        func(k+1,i+1);
    }
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>N>>M;
    for(int i=1;i<=N;i++)
        for(int j=1;j<=N;j++)
        {
            cin>>city[i][j];
            if(city[i][j]==1) h.push_back({i,j});
            if(city[i][j]==2) c.push_back({i,j});
        }
    cin>>M;
    selected.resize(M);
    func(0,0);
    cout<<result;
    return 0;
}
