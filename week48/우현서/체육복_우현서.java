// 학생 번호는 체격 순, 바로 앞/뒤에게만 빌려줄 수 있음
// 최대한 많은 학생이 수업듣게

import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(reserve);

        boolean[] students = new boolean[n+2];
        Arrays.fill(students, true);
        for (int l: lost) {
            students[l] = false;
        }

        int cannot = lost.length;

        boolean[] canLend = new boolean[n+2];
        for (int r: reserve) {
            if (students[r]) {
                canLend[r] = true;
            } else {
                cannot--;
                students[r] = true;
            }
        }


        for (int r: reserve) {
            if (!canLend[r]) continue;

            boolean used = false;

            if (!students[r-1] && !used) {
                students[r-1] = true;
                cannot--;
                used = true;
            }

            if (!students[r+1] && !used) {
                students[r+1] = true;
                cannot--;
            }
        }


        return n-cannot;
    }
}