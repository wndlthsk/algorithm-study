// 출근 희망 시간 + 10분까지 출근한 직원들에게 상품
// 일주일간 (주말은 제외)
// 몇명이 상품 받는지 구하기
// 시간은 시*100+분

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;

        int[] count = new int[n];

        for (int i=0; i<7; i++) {
            int day = (startday + i) % 7;
            if (day == 6 || day == 0) continue;

            for (int j=0; j<n; j++) {
                if (toMin(timelogs[j][i]) <= toMin(schedules[j])+10) count[j]++;
            }
        }

        int answer = 0;
        for (int c: count) {
            if (c == 5) answer++;
        }

        return answer;
    }

    private int toMin(int hhmm) {
        int h = hhmm / 100;
        int m = hhmm % 100;
        return h * 60 + m;
    }

}