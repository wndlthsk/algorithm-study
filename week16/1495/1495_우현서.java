// v[i] : i번째 곡을 연주하기 전에 바꿀 수 있는 볼륨
// 현재 볼륨이 p, 지금 i번째 곡을 연주하기 전이라면, i번 곡은 p+v[i]나 p-v[i]로 연주해야한다.
// 0보다 작거나 m보다 큰 값으로 바꿀 수 없다.
// n: 곡의 개수, s: 시작 볼륨, m
// 마지막 곡을 연주할 수 있는 볼륨 중 최댓값 구하기
// 모든 곡은 리스트에 적힌 순서대로 연주해야한다.
// 마지막 곡을 연주할 수 없다면 -1 리턴
// 1 ≤ N ≤ 50, 1 ≤ M ≤ 1,000, 0 ≤ S ≤ M

// 1. 이전 곡까지의 결과로 나올 수 있는 볼륨을 저장하고, 이를 마지막 곡까지 갱신한다.
// 2. dp[i][j]: i번째 곡까지 연주했을 때 j볼륨의 가능 여부 --> boolean[][]으로 둔다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] v = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> before = new HashSet<>(); // 계산 결과가 중복이 되는 경우가 있기때문에 이를 막기 위해서(리스트는 메모리 초과남)
        before.add(s);
        Set<Integer> nowList;
        for (int now: v){
            nowList = new HashSet<>();
            for (int b: before){
                if (b-now >= 0) {
                    nowList.add(b-now);
                }
                if (b+now <= m) {
                    nowList.add(b+now);
                }
            }
            before = nowList; // 얕은 복사=참조 복사
        }
//        System.out.println(before);

        if (before.isEmpty()) {
            System.out.println("-1");
        } else {
            System.out.println(Collections.max(before));
        }

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int s = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int[] v = new int[n+1];
//        st = new StringTokenizer(br.readLine());
//        for (int i=1; i<=n; i++) {
//            v[i] = Integer.parseInt(st.nextToken());
//        }
//
//        boolean[][] dp = new boolean[n+1][m+1];
//        dp[0][s] = true;
//        for (int i=1; i<=n; i++) {
//            for (int j=0; j<=m; j++) {
//                if (dp[i-1][j]) { // 이전 곡에서 j볼륨이 가능하면
//                    // 현재곡 볼륨 조절 해본다
//                    if (j - v[i] >= 0) {
//                        dp[i][j - v[i]] = true;
//                    }
//                    if (j + v[i] <= m) {
//                        dp[i][j + v[i]] = true;
//                    }
//                }
//            }
//        }
//
//        int result = -1;
//        for (int j=0; j<=m; j++) {
//            if (dp[n][j]) {
//                result = Math.max(result, j);
//            }
//        }
//
//        System.out.println(result);
    }
}