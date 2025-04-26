#include <bits/stdc++.h>
using namespace std;

int L, C;
string s;             // 사용가능한 문자들로 이루어진 문자열
string must = "aeiou"; // 이중에 적어도 하나의 포함되어야함
vector<string> result; // 가능한 후보 저장
string tmp;

void func(int k, int st)
{
    // L개 문자 선택 완료 (Base Case)
    if (k == L)
    {
        int vowel_cnt = 0;
        int cons_cnt = 0;

        // 모음/자음 개수 확인
        for (char c1 : tmp)
        {
            bool is_vowel = false;
            for (char c2 : must)
            {
                if (c1 == c2)
                {
                    is_vowel = true;
                    break;
                }
            }
            if (is_vowel)
            {
                vowel_cnt++;
            }
            else
            {
                cons_cnt++;
            }
        }

        // 조건 만족 시 결과에 추가 (모음>=1, 자음>=2)
        if (vowel_cnt >= 1 && cons_cnt >= 2)
        {
            result.push_back(tmp);
        }
        return;
    }

    // 다음 문자 선택
    for (int i = st; i < C; i++)
    {
        tmp[k] = s[i];
        func(k + 1, i + 1);
    }
}

int main()
{
    ios::sync_with_stdio(0);
    cin.tie(0);

    cin >> L >> C; // 4자리 암호  , 6개 사용해서
    s.resize(C);
    for (int i = 0; i < C; i++)
    {
        cin >> s[i]; // atcisw
    }

    sort(s.begin(), s.end());

    tmp.resize(L);

    func(0, 0);

    // 정렬 후 출력
    sort(result.begin(), result.end());
    for (string res_s : result)
    {
        cout << res_s << '\n';
    }

    return 0;
}
