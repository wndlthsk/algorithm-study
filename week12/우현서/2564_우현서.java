// 블록 바깥을 돌아서 각 상점에 가는 최단 거리의 합
// 1: 북, 2: 남, 3: 서, 4: 동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // 북동남서 순으로 일직선으로 만든다
    int toLinear(int m, int n) { // 가로, 세로
        switch (x) {
            case 1: return y;
            case 2: return n + m + (n - y);
            case 3: return n + m + n + (m - y);
            case 4: return n + y;
            default: return 0;
        }
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 세로n x 가로m
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(br.readLine()); // 상점 개수
        List<Point> stores = new ArrayList<>();
        for(int i=0; i<s; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stores.add(new Point(x, y));
        }
//        System.out.println(stores);

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        Point dong = new Point(x, y); // 동근이 위치

        int result = 0;
        // 2. 모든 좌표 일직선으로 변경 후 계산
        int dongLinear = dong.toLinear(n, m);
//        System.out.println(dongLinear);
        int total = 2 * (n+m);

        for(Point p : stores) {
            int pLinear = p.toLinear(n, m);
            int abs = Math.abs(dongLinear - pLinear);
            result += Math.min(abs, total-abs);
//            System.out.println(p + " " +  result);
        }

        // 1. 모든 경우 if 문으로 처리
//        for(Point p : stores) {
//            // 서로 반대인 경우 시계, 반시계 비교해서 최솟값 구한다
//            if ((p.x == 1 && dong.x == 2) || (p.x == 2 && dong.x == 1)) {
//                int try1 = dong.y + n + p.y;
//                int try2 = (m-dong.y) + n + (m-p.y);
//                result += Math.min(try1, try2);
//            }
//            else if ((p.x==3 && dong.x == 4) || (p.x==4 && dong.x ==3)) {
//                int try1 = dong.y + m + p.y;
//                int try2 = (n-dong.y) + m + (n-p.y);
//                result += Math.min(try1, try2);
//            }
//            else if(dong.x == 1 && p.x == 3) { // 북-서
//                result += dong.y + p.y;
//            }
//            else if(dong.x == 1 && p.x == 4) { // 북-동
//                result += (m-dong.y) + p.y;
//            }
//            else if(dong.x == 2 && p.x == 3) { // 남-서
//                result += dong.y + (n-p.y);
//            }
//            else if(dong.x == 2 && p.x == 4) { // 남-동
//                result += (m-dong.y) + (n-p.y);
//            }
//            else if(dong.x == 3 && p.x == 1) { // 서-북
//                result += dong.y + p.y;
//            }
//            else if(dong.x == 3 && p.x == 2) { // 서-남
//                result += (n-dong.y) + p.y;
//            }
//            else if(dong.x == 4 && p.x == 1) { // 동-북
//                result += dong.y + (m-p.y);
//            }
//            else if(dong.x == 4 && p.x == 2) { // 동-남
//                result += (n-dong.y) + (m-p.y);
//            }
//            else if (dong.x == p.x) {
//                result += Math.abs(dong.y - p.y);
//            }
//        }
        System.out.println(result);
    }

}