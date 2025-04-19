#include <vector>
using namespace std;

vector<int> solution(int N, int M, vector<int> A) {
    vector<int> res;
    vector<pair<int, int>> v;

    // ID는 1-based, A는 0-based
    for (int i = 0; i < N; ++i)
        v.push_back({i + 1, A[i]});

    while (v.size() > 1) {
        vector<pair<int, int>> nxt;
        for (int i = 0; i < v.size(); i += 2) {
            auto a = v[i], b = v[i + 1];
            pair<int, int> winner;

            if (a.first == M || b.first == M) {
                int opponent = (a.first == M) ? b.first : a.first;
                res.push_back(opponent);
                winner = (a.first == M) ? a : b;
            } else {
                if (a.second != b.second)
                    winner = (a.second > b.second) ? a : b;
                else
                    winner = (a.first < b.first) ? a : b;
            }

            nxt.push_back(winner);
        }
        v = nxt;
    }

    return res;
}
