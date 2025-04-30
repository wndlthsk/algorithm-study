/* 
1. like 피보나치 수열 but
2. 문제힌트 전날 + 전전날 떡 개수 = 규칙을 말함 전형적인 DP(특히 피보나치)
3. 현재값 = 이전값들을 이용해서 계산 : 점화식이 존재
4. 부분 문제의 결과 -> 전체 문제에 활용 : YES
5. 중복계산이 많아질것 같음 : DP로 최적화 필요요 + N범위도 30 O(N)에 가능
*/
#include <bits/stdc++.h>
using namespace std;

int D,K;
int x[31],y[31];

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    cin >> D >> K;

    x[1] = 1; y[1] = 0;
    x[2] = 0; y[2] = 1;

    for( int i = 3; i <= D; i++){
        x[i] = x[i-1] + x[i-1];
        y[i] = y[i-1] + y[i-1];
    }

    for( int A = 1; A <= 1000000;A++){
        int temp = K - A*x[D];  // 자연수 B를 찾기 위한 임시 방정식
        if( temp % y[D] != 0) continue; //B 갯수가 자연수여야함함
        int B = temp / y[D];
        if( B >= A && B<=100000){
            cout << A <<'\n' << B << '\n';
            break;
        }
    }
}

