#include <bits/stdc++.h>
using namespace std;

int arr[1025][1025];
int psum[1025][1025];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    
    int n, m;
    cin >> n >> m;

    // 배열 입력 및 누적합 계산
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            cin >> arr[i][j];
            psum[i][j] = psum[i-1][j] + psum[i][j-1] - psum[i-1][j-1] + arr[i][j];
        }
    }

    // 질의 처리
    while (m--) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;
        int result = psum[x2][y2] - psum[x1-1][y2] - psum[x2][y1-1] + psum[x1-1][y1-1];
        cout << result << '\n';
    }

    return 0;
}
