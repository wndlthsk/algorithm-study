// u x: x칸 위 행 선택
// d x: x칸 아래 행 선택
// c: 현재 칸 삭제 후 아래 행 선택 / 삭제가 마지막 행이면 윗 행 선택
// z: 최근 삭제 행 복구, 선택 행 바뀌지 않음
// 처음 표랑 비교해 삭제되지 않은 행은 o, 삭제된 행은 x로 문자열 리턴
// n: 처음 표 행 개수
// k: 처음 선택된 행 위치
// cmd: 수행한 명령어

// 명령문에 따라 포인터 관리?
// 삭제한건 스택에 인덱스 넣고, z누르면 팝시키기
// 근데 삭제된 후 포인터 이동시키려면 삭제된 행은 빼고 이동해야함
// prev[] , next[]로 전체 행의 앞뒤 포인터 관리

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int pointer = k;
        Deque<Integer> deleted = new ArrayDeque<>();
        char[] state = new char[n];
        Arrays.fill(state, 'O');

        int[] prev = new int[n];
        int[] next = new int[n];
        for (int i=0; i<n; i++) {
            prev[i] = i-1;
            next[i] = i+1;
            if (i == n-1) next[i] = -1;
        }

        for (String c: cmd) {
            // String[] splited = c.split(" ");
            char op = c.charAt(0);

            if (op == 'U' || op == 'D') {
                int x = Integer.valueOf(c.substring(2));

                if (op == 'U') {
                    for (int i=0; i<x; i++) {
                        pointer = prev[pointer];
                    }

                } else { // d
                    for (int i=0; i<x; i++) {
                        pointer = next[pointer];
                    }
                }

            } else if (op == 'C') {
                deleted.addLast(pointer);
                state[pointer] = 'X';

                int before = prev[pointer];
                int after = next[pointer];

                if (before!=-1) next[before] = after;
                if (after!=-1) prev[after] = before;

                pointer = (after != -1) ? after: before;

            } else { // z
                int idx = deleted.pollLast();
                state[idx] = 'O';

                int before = prev[idx];
                int after = next[idx];

                if (before!=-1) next[before] = idx;
                if (after!=-1) prev[after] = idx;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char s: state) {
            sb.append(s);
        }
        // System.out.println(sb.toString());

        return sb.toString();
    }
}