#include <bits/stdc++.h>
using namespace std;

const int MX = 50;

int delnode, cnt, root;
vector<int> child[MX + 2];

void bfs() {
  if(root == delnode) return;
  queue<int> q;
  q.push(root);
  while(!q.empty()) {
    int cur = q.front(); q.pop();
    bool isleaf = 1;
    for(int c : child[cur]) {
      if(c == delnode) continue;
      isleaf = 0;
      q.push(c);
    }
    cnt += isleaf;
  }
}

int main() {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int n; cin >> n;
  for(int i = 0; i < n; i++) {
    int p; cin >> p;
    if(p == -1) { root = i; continue; }
    child[p].push_back(i);
  }

  cin >> delnode;
  bfs();
  cout << cnt;
}
