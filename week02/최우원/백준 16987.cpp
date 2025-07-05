#include <bits/stdc++.h>
using namespace std;
int n;
int s[10],w[10];
int mx = 0;
int cnt = 0; 

void solve(int a){ 
  if(a == n){
    mx = max(mx,cnt);
    return;
  }
  if(s[a] <= 0 or cnt == n-1){
    solve(a+1);
    return;
  } 
  for(int t = 0; t < n; t++){ 
    if(t == a or s[t] <= 0) continue;
    s[a] -= w[t];
    s[t] -= w[a];
    if(s[a] <= 0) cnt++;
    if(s[t] <= 0) cnt++;
    solve(a+1);
    if(s[a] <= 0) cnt--;
    if(s[t] <= 0) cnt--;    
    s[a] += w[t];
    s[t] += w[a];
  }
}

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);
  cin >> n;
  for(int i = 0; i < n; i++){
    cin >> s[i] >> w[i];
  }
  solve(0);
  cout << mx;  
}
