// 불만도 = |A(예상) - B(실제)|
// 불만도의 총합을 최소로 하면서 학생 등수를 매김
// n명 (1<=n<=500000)

// 1based 배열 (n+1크기)
// 입력받은 등수들 오름차순 정렬해서, 각 배열의 인덱스와의 차이를 누적해서 더한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] scores = new int[n+1];
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }
//        System.out.println(Arrays.toString(scores));

        Arrays.sort(scores);
//        System.out.println(Arrays.toString(scores));

        long tempSum = 0;
        for (int i = 1; i <= n; i++) {
            tempSum += Math.abs(i-scores[i]);
        }

        System.out.println(tempSum);
    }
}