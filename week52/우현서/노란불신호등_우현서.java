// 모두 노란불되는 가장 빠른 시각
// 3~4/ (2+2+1) 8~9 // +5 13~14
// 6~7 / (1+5+1) 13~14


class Solution {
    public int solution(int[][] signals) {
        int answer = 0;
        int n = signals.length;

        int limit = 1;
        for (int[] s: signals) {
            int cycle = s[0] + s[1] + s[2];
            limit = lcm(limit, cycle);
        }

        int[] yellow = new int[limit];

        for (int[] s: signals) {
            int time = 1 + s[0];

            while (time < limit) {

                for (int i=0; i<s[1]; i++) {
                    if (time + i < limit) {
                        yellow[time+i]++;

                        if (yellow[time+i] == n) return time+i;
                    }
                }

                time += s[0] + s[1] + s[2];
            }

        }
        // System.out.println(Arrays.toString(yellow));


        return -1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}