// n*m, 공
// 좌, 우, 상, 하
// 격자 밖이면 안에서 멈춤
// x,y에 도착하는 시작점 개수 리턴


class Solution {

    public long solution(int n, int m, int x, int y, int[][] queries) {

        int x1 = x, x2 = x;
        int y1 = y, y2 = y;

        for (int i=queries.length-1; i>=0; i--) {
            int[] q = queries[i];
            int d = q[0];
            int k = q[1];


            if (d == 0) { // 좌
                if (y1 != 0) y1 += k;
                y2 = Math.min(m-1, y2+k);
            } else if (d == 1) { // 우
                y1 = Math.max(0, y1 - k);
                if (y2 != m-1) y2 -= k;
            } else if (d == 2) { // 상
                if (x1 != 0) x1 += k;
                x2 = Math.min(n-1, x2+k);
            } else { // 하
                x1 = Math.max(0, x1 - k);
                if (x2 != n-1) x2 -= k;
            }

            // System.out.println(x1 + ", " + y1 + " / " + x2 + ", " + y2);

            if (x1 > x2 || y1 > y2) return 0;

        }

        //System.out.println(x1 + ", " + y1 + " / " + x2 + ", " + y2);

        return (long)(x2 - x1 + 1) * (y2 - y1 + 1);

    }

}