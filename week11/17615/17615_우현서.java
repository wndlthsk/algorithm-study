import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int fromFirst(char[] balls, char color) {
        int cnt = 0;
        for (char ball : balls) {
            if (ball == color) cnt ++;
            else break;
        }
        return cnt;
    }

    static int fromLast(char[] balls, char color) {
        int cnt = 0;
        for (int i = balls.length-1; i >= 0; i--) {
            if (balls[i] == color) cnt ++;
            else break;
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String balls = br.readLine();

        // 색깔별 공 개수
        int red = 0, blue = 0;
        for (int i = 0; i < n; i++) {
            if (balls.charAt(i) == 'R') red++;
            else blue++;
        }

        char[] ballsChars = balls.toCharArray();
        int minimum = n;

        // 왼쪽 모으기
        int count = fromFirst(ballsChars, 'R');
        minimum = Math.min(red-count, minimum);

        count = fromFirst(ballsChars, 'B');
        minimum = Math.min(blue-count, minimum);

        // 오른쪽 모으기
        count = fromLast(ballsChars, 'R');
        minimum = Math.min(red-count, minimum);

        count = fromLast(ballsChars, 'B');
        minimum = Math.min(blue-count, minimum);

        System.out.println(minimum);
    }
}