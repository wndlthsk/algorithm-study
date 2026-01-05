import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 리모컨 버튼 0~9,+,-
// 0에서 -누르면 안변함, 채널 무한대
// n: 이동하려는 채널
// 고장난 버튼 있고, n으로 이동하기 위해 최소 눌러야하는 횟수
// 현재 채널: 100

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] broken = new boolean[10];
        if (m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int b = Integer.parseInt(st.nextToken());
                broken[b] = true;
            }
        }

        // 499900
        int min = Math.abs(n - 100);
        for (int x = 0; x <= Math.abs(n - 100) + n; x++) {
            String s = Integer.toString(x);
            // 현재 x가 눌릴 수 있는 숫자인지 확인
            boolean canClicked = true;
            for (int i = 0; i < s.length(); i++) {
                int y = s.charAt(i) - '0';
                if (broken[y]) {
                    canClicked = false;
                    break;
                }
            }
            if (!canClicked) continue;

            // 눌릴 수 있는 숫자면 min값 갱신
            int count = s.length() + Math.abs(x - n);
            min = Math.min(min, count);
        }

        System.out.println(min);
    }
}