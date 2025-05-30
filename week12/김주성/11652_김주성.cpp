#include<bits/stdc++.h>
using namespace std;
long long max_num=0;
long long max_val;
int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);
    int N;
    cin>>N;
    vector<long long> card(N);
    vector<long long> card_unique;
    for(int i=0;i<N;i++)  cin>>card[i];
    sort(card.begin(),card.end());

    long long prev=card[0];
    card_unique.push_back(card[0]);
    for(int i=1;i<N;i++)
    {
        if(card[i]==prev) continue;
        prev=card[i];
        card_unique.push_back(card[i]);
    }

    int siz=card_unique.size();
    for(int i=0;i<siz;i++)
    {
        
        int num=upper_bound(card.begin(),card.end(),card_unique[i])-lower_bound(card.begin(),card.end(),card_unique[i]);
        
        if(num>max_num)
        {
            max_num=num;
            max_val=card_unique[i];
           
        }
        else if(num==max_num)
        {
            max_val=min(card_unique[i],max_val);
        }
    }
    cout<<max_val;
    return 0;
}
