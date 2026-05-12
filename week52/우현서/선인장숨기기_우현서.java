// mxn
// 선인장이 가능한 늦게 비 맞게 선인장 구역 위치
// 여러개면 가장 위 > 가장 왼쪽에 위치한 구역

// 완탐 안되나?

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {

        int[][] time = new int[m][n];
        for (int i=0; i<m; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }

        for (int order=0; order<drops.length; order++) {
            int x = drops[order][0];
            int y = drops[order][1];

            time[x][y] = order+1;
        }
        // System.out.println(Arrays.deepToString(time));

        // 길이 w 구간 최소값 구하기
        int[][] rowMin = new int[m][n-w+1];

        for (int r = 0; r < m; r++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int c = 0; c < n; c++) {
                while (!dq.isEmpty() && time[r][dq.peekLast()] >= time[r][c]) {
                    dq.pollLast();
                }

                dq.addLast(c);

                if (dq.peekFirst() <= c - w) {
                    dq.pollFirst();
                }

                // 길이 w 완성됐으면 최소값 저장
                if (c >= w - 1) {
                    rowMin[r][c - w + 1] = time[r][dq.peekFirst()];
                }
            }
        }

        // 길이 h 구간 최솟값 구하기
        int[][] rectMin = new int[m-h+1][n-w+1];

        for (int c = 0; c < n-w+1; c++) {
            Deque<Integer> dq = new ArrayDeque<>();

            for (int r = 0; r < m; r++) {
                while (!dq.isEmpty() && rowMin[dq.peekLast()][c] >= rowMin[r][c]) {
                    dq.pollLast();
                }

                dq.addLast(r);

                if (dq.peekFirst() <= r - h) {
                    dq.pollFirst();
                }

                if (r >= h - 1) {
                    rectMin[r - h + 1][c] = rowMin[dq.peekFirst()][c];
                }
            }
        }

        // 가장 느린거 찾기
        int best = -1;
        int ansR = 0;
        int ansC = 0;

        for (int r = 0; r < m-h+1; r++) {
            for (int c = 0; c < n-w+1; c++) {
                if (rectMin[r][c] > best) {
                    best = rectMin[r][c];
                    ansR = r;
                    ansC = c;
                }
            }
        }

        return new int[]{ansR, ansC};
    }
}