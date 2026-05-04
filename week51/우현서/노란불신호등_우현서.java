// 초-> 노-> 빨 반복
// 시작은 1초, 초록불
// 모든 신호가 노란불되면 정전 발생, 가장 빠른 시각 리턴, 없으면 -1 리턴

// 3/ (+4+1) 8 / 13
// 6/ (+6+1) 13 /

class Solution {
    public int solution(int[][] signals) {

        int maxTime = 1;
        for (int[] s : signals) {
            int cycle = s[0] + s[1] + s[2];
            maxTime = lcm(maxTime, cycle);
        }
        maxTime += 1; // 여유

        int[] visited = new int[maxTime];
        int n = signals.length;


        for (int[] s: signals) {
            int t = 1+s[0];

            while (t < maxTime) {
                for (int k = 0; k < s[1] && t+k<maxTime; k++) {
                    visited[t + k]++;
                }
                t += s[0] + s[1] + s[2];
            }

        }

        for (int i = 0; i < maxTime; i++) {
            if (visited[i] == n) return i;
        }

        return -1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

}