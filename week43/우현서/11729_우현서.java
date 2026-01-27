import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3개의 장대, 첫번째에 원판 n개
// 한번에 한개를 옮김
// 항상 위으 ㅣ것이 아래보다 작아야한다
// 첫번째 -> 세번째로 최소 이동으로 옮겨라


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        move(n, 1, 2, 3);
        System.out.println(count);
        System.out.print(sb.toString());
    }

    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void move(int n, int from, int via, int to) {
        if (n == 0) return;
        count++;

        move(n-1, from, to, via); // n-1개를 via로 옮기기
        sb.append(from + " " + to + "\n"); // 젤 큰거 to로 옮기기
        move(n-1, via, from, to); // n-1개를 to로 옮기기
    }
}