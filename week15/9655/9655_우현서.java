// 돌 n개
// 상근 vs 창영, 돌 1개 or 3개 가져갈 수 있음. 마지막 돌 가져가는 사람이 이김.
// 이기는 사람 구하기. 상근이가 선

// 홀수개면 상근, 짝수는 창영이 이김.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");
        }
    }

}