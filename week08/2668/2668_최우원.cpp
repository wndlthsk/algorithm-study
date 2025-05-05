#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

const int MAX = 101;
int n;
int arr[MAX];
bool visited[MAX];
vector<int> result;

void dfs(int start, int current) {
    if(visited[current]) {
        if(start == current) {
            result.push_back(start);
        }
        return;
    }
    
    visited[current] = true;
    dfs(start, arr[current]);
}

int main() {
    cin >> n;
    
    for(int i=1; i<=n; i++) {
        cin >> arr[i];
    }
    
    for(int i=1; i<=n; i++) {
        fill(visited, visited+MAX, false);
        dfs(i, i);
    }
    
    sort(result.begin(), result.end());
    
    cout << result.size() << "\n";
    for(int num : result) {
        cout << num << "\n";
    }
    
    return 0;
}
