// U X: 현재 칸 x칸 윗 행 선택
// D X: 현재 칸 x칸 아래 행 선택
// C: 현재 칸 삭제, 아래 행 선택. 마지막행이면 윗행 선택
// Z: 가장 최근 삭제 행 복구, 선택 행 그대로

// n: 행 개수
// k: 선택 행
// cmd: 명령어 배열
// 처음 상태랑 비교해서 삭제안된 행은 O, 삭제된 행은 X

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] up = new int[n];
        int[] down = new int[n];
        up[0] = -1;
        down[n-1] = -1;
        for (int i=1; i<n; i++) {
            up[i] = i-1;
        }
        for (int i=0; i<n-1; i++) {
            down[i] = i+1;
        }

        Deque<Integer> deleted = new ArrayDeque<>(); // 스택으로 사용
        boolean[] isNotDeleted = new boolean[n];
        Arrays.fill(isNotDeleted, true);

        for (String c: cmd) {
            if (c.length() > 1) {
                String[] splited = c.split(" ");
                int x = Integer.parseInt(splited[1]);

                if (splited[0].equals("U")) { // 위로 이동
                    for (int i=0; i<x; i++) {
                        k = up[k];
                    }
                } else { // 아래로 이동
                    for (int i=0; i<x; i++) {
                        k = down[k];
                    }
                }

            } else {
                if (c.equals("C")) { // 현재칸 삭제
                    deleted.addLast(k);
                    isNotDeleted[k] = false;

                    if (up[k] != -1) down[up[k]] = down[k];
                    if (down[k] != -1) up[down[k]] = up[k];

                    if (down[k] != -1) k = down[k];
                    else k = up[k];

                }
                else { // 최근 삭제 복구
                    int x = deleted.removeLast();
                    isNotDeleted[x] = true;

                    if (up[x] != -1) down[up[x]] = x;
                    if (down[x] != -1) up[down[x]] = x;

                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (boolean b: isNotDeleted) {
            if (b) sb.append("O");
            else sb.append("X");
        }

        return sb.toString();
    }
}