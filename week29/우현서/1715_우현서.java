import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

// 정렬된 두 묶음의 숫자 카드, 각 카드 수 a, b
// n개의 숫자 카드 묶음의 각각 크기
// 최소 비교 횟수 구하기

// 최소 카드 수끼리 먼저 비교

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> cards = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            cards.add(Integer.parseInt(br.readLine()));
        }

        int result = 0;
        while (cards.size() >= 2) {
            int sum = 0;

            sum += cards.poll();
            sum += cards.poll();
            result += sum;
//            System.out.println(cards);
            cards.offer(sum);
//            System.out.println(cards);
//            System.out.println("result : " + result);
        }

//        System.out.println(cards);
        System.out.println(result);

    }

}