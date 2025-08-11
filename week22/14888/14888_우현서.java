// n개로 이루어진 수열 A, 수 사이에 넣을 n-1개의 연산자 (+,-,*,/)
// 주어진 수를 바꾸지 않고 연산자를 하나씩 넣어 수식으,ㄹ 만든다.
// 식 계싼은 연산자 우선 순위를 무시하고 앞에서부터 진행, 나눗셈은 몫만 취핞다.
// 만들 수 있는 식의 결과의 최댓값, 최솟값 구하기

// 백트래킹

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        backtrack(1, A[0], n, operator, A);
        System.out.println(max);
        System.out.println(min);


    }

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void backtrack(int count, int sum, int n, int[] operator, int[] A) { // 계산한 숫자 카운트
        if (count == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;
                if (i == 0) {
                    backtrack(count+1, sum + A[count], n, operator, A);
                }
                else if (i == 1) {
                    backtrack(count+1, sum - A[count], n, operator, A);
                }
                else if (i == 2) {
                    backtrack(count+1, sum * A[count], n, operator, A);
                }
                else if (i == 3) {
                    backtrack(count+1, sum / A[count], n, operator, A);
                }
                operator[i]++;
            }
        }
    }
}