#include<bits/stdc++.h>
using namespace std;
unordered_map<string,int> h;
int K,L;
//second가 작은 순(순위낮은 순 정렬)
bool cmp(pair<string,int> a,pair<string,int> b)
{
    if(a.second!=b.second) return a.second<b.second;
    return false;
}
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin>>K>>L; //순위 1~L 아님.중복될수도.
    int order = 1;
    int num_list=0;
    string std_num;

    for(int i=0;i<L;i++)
    {
        cin>>std_num;
        h[std_num]=order;
        order++;
    }
    
    //벡터로 요소 복사 후 정렬
    vector<pair<string,int>> v;
    pair<string,int> tmp;
    for(auto c:h)
    {
        tmp.first=c.first;
        tmp.second=c.second;
        v.push_back(tmp);
    }
    sort(v.begin(),v.end(),cmp);
    
    //K개 만큼 출력
   int success =0;
   for(auto c:v)
   {
        if(success==K) break;
        cout<<c.first<<'\n';
        success++;
   }

    return 0;
    
    
}
