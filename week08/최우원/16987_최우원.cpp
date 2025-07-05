#include <bits/stdc++.h>
using namespace std;

int n;
int mx,cnt;
int s[];
int w[];

void solve(int a){
    if( a == n){
        mx = max(mx,cnt);
        return ;
    }
    for(int i = 0; i < n; i++){
        if( i == a || s[a] <= 0 ) continue;
        s[a] -= w[i];
        s[i] -= w[a];
        if (s[a] <= 0) cnt++;
        if (s[i] <= 0) cnt++;
        solve(a+1);
        s[a] += w[i];
        s[i] += w[a];
    }
}

int main(){
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> n;
    for(int i=0; i<n; i++){
        cin >> s[n] >> w[n] ;
    }
    solve(0);
    cout << cnt ;
}
