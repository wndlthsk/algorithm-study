#include<bits/stdc++.h>
using namespace std;

int n;
int arr[101];
int vis[101];
vector<int> ans;

void dfs(int u) {
    vis[u] = 1;
    int v = arr[u];

    if (vis[v] == 0) {
        dfs(v);
    } else if (vis[v] == 1) {
        int cur_node = v;
        while (true) {
            ans.push_back(cur_node);
            cur_node = arr[cur_node];
            if (cur_node == v) break;
        }
    }
    vis[u] = 2;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    for (int i = 1; i <= n; ++i) {
        cin >> arr[i];
    }

    for (int i = 1; i <= n; ++i) {
        if (vis[i] == 0) {
            dfs(i);
        }
    }

    sort(ans.begin(), ans.end());

    cout << ans.size() << "\n";
    for (int val : ans) {
        cout << val << "\n";
    }

    return 0;
}
