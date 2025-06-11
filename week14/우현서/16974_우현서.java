// 1: b<p>p<p>b, 2: b<bpppb>p<bpppb>b
// 아래 x장을 먹었을 때 먹은 패티의 수 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        // 패티 재귀
        // patty[0] = 1, patty[n] = 2*patty[n-1] + 1
        // 길이
        // len[0] = 1, len[n] = 2*len[n-1] + 3
        long[] patty = new long[n+1];
        long[] len = new long[n+1];
        patty[0] = 1;
        len[0] = 1;
        for (int i = 1; i < n+1; i++) {
            patty[i] = 2*patty[i-1] + 1;
            len[i] = 2*len[i-1] + 3;
        }

        System.out.println(countPatty(n, x, patty, len));
    }

    static private long countPatty(int n, long x, long[] patty, long[] len) {
        if (n==0) return x <= 0 ? 0: 1;

        // <b>+이전부분+p+이전부분+b
        if (x == 1) return 0;
        long l = len[n-1];
        // b+<이전 부분>+이전부분+b 에서 첫번째 이전 부분의 어딘가를 먹으면 이전 레벨에서 확인해야함
        if (x <= 1 + l) return countPatty(n-1, x-1, patty, len);
        // b+이전부분+<p>+이전부분+b
        if (x <= 1 + l + 1) return patty[n-1] + 1;
        // b+이전부분+p+<이전부분>+b
        if (x <= 1 + l + 1 + l) return patty[n-1] + 1 + countPatty(n-1, x-(1+l+1), patty, len);

        return patty[n];
    }
}