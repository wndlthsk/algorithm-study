import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 수열 A, n개의 수
// 모든 수 사이에 연산자 한개 끼워야함. 연산자는 남을 수 있음
// 수열의 순서는 바꾸면 안됨
// 계싼은 연산자 우선순위 무시, 앞에서부터
// 나눗셈은 몫만 취함
// 만들 수 있는 식의 결과의 최대, 최소 구하기

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[] op = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(op));

        backtrack(op, a, 1, a[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void backtrack(int[] op, int[] a, int idx, int sum) {
        if (idx == a.length) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }


        for (int i = 0; i < 4; i++) {
            if (op[i] <= 0) continue;
            op[i]--;
            if (i==0) backtrack(op, a, idx + 1, sum + a[idx]);
            else if (i==1) backtrack(op, a, idx + 1, sum - a[idx]);
            else if (i==2) backtrack(op, a, idx + 1, sum * a[idx]);
            else if (i==3) backtrack(op, a, idx + 1, sum / a[idx]);
            op[i]++;
        }
    }

}