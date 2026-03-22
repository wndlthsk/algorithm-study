// 초침이 시침/분침과 겹칠때마다 알람 울림
// 알람 울린 횟수 구하기

// 이전 1초 동안 초침이 분침(또는 시침)을 추월했는가?

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        int time = h1*3600 + m1*60 + s1;
        int target = h2*3600 + m2*60 + s2;

        double sa = secondAngle(time);
        double ma = minuteAngle(time);
        double ha = hourAngle(time);

        boolean smStart = diff(sa, ma) < 1e-9 ? true : false;
        boolean shStart = diff(sa, ha) < 1e-9 ? true : false;
        if (smStart) answer++;
        if (shStart) answer++;
        if (smStart && shStart) answer--;

        double prevdiff1 = diff(sa, ma);
        double prevdiff2 = diff(sa, ha);
        while (time < target) {
            time++;
            double curdiff1 = diff(secondAngle(time), minuteAngle(time));
            double curdiff2 = diff(secondAngle(time), hourAngle(time));

            boolean sm = false;
            boolean sh = false;
            if (curdiff1 < prevdiff1) {
                sm = true;
                answer++;
            }
            if (curdiff2 < prevdiff2) {
                sh = true;
                answer++;
            }

            if (sm && sh && (time % 43200 == 0)) { // 현재가 12시일때만 겹침
                answer--;
            }


            prevdiff1 = curdiff1;
            prevdiff2 = curdiff2;
        }

        return answer;
    }

    private double diff(double a, double b) {
        return (a - b + 360) % 360;
    }

    private double secondAngle(double t) {
        return (6 * t) % 360;
    }

    private double minuteAngle(double t) {
        return (0.1 * t) % 360;
    }

    private double hourAngle(double t) {
        return (t / 120.0) % 360;
    }
}