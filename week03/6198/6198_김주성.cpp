#include <bits/stdc++.h>
using namespace std;

int N;
long long total;
stack<long long> s;

int main() {
    cin >> N;

    for (int i = 0; i < N; i++) {
        long long h;
        cin >> h;

       
        while (!s.empty() && s.top() <= h) {
            s.pop();
        }
        total += s.size();

        s.push(h);
    }

    cout << total;
    return 0;
}
