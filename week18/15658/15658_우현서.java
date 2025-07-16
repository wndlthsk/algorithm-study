// 수열 A (n개 수로 이루어짐)
// 연산자 : +, -, *, / 개수는 n-1보다 많을 수도 있다.
// 모든 수 사이에 연산자 한개를 끼워야한다. 모든 연산자를 사용안해도 됨
// 주어진 수의 순서를 바꾸면 안된다
// 연산자 우선순위 무시하고 앞에서부터 계싼함
// 나눗셈은 몫만 취한다.
// 만들 수 있는 식의 결과의 최대, 최소 구하기


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] a, operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        operator = new int[4];
        for (int i=0; i<4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(operator));
//        System.out.println(Arrays.toString(a));

        backtrack(1, a[0]);
        System.out.println(max);
        System.out.println(min);

    }
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    static public void backtrack(int count, int current) { // (사용한 숫자, 현재까지 계산 값)
        if (count == n) {
            max = Math.max(max, current);
            min = Math.min(min, current);
            return;
        }

        for (int i=0; i<4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                int next = 0;
                if (i == 0) {
                    next = current + a[count];
                } else if (i == 1) {
                    next = current - a[count];
                } else if (i == 2) {
                    next = current * a[count];
                } else {
                    next = current / a[count];
                }
                backtrack(count+1, next);
                operator[i]++;
            }
        }
    }
}