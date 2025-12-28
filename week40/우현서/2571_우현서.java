import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 가로세로 100 흰 도화지
// 가로세로 10인 검은색 색종이를 도화지 변과 평행하도록 붙인다.
// 색종이 여러장 붙인 후 검은색 직사각형 잘라낸다
// 잘라낼 수 있는 검은색 직사각형의 최대 넓이 구하기


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] arr = new boolean[100][100];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int r = y; r < y+10; r++) {
                for (int c = x; c < x+10; c++) {
                    arr[r][c] = true;
                }
            }
        }

        int[][] height = new int[100][100];
        for (int j=0; j<100; j++) {
            height[0][j] = arr[0][j] ? 1 : 0;
        }

        int max = 0;
        for (int i=1; i<100; i++) {
            for (int j=0; j<100; j++) {
                if (arr[i][j]) height[i][j] = height[i-1][j] + 1;
                else height[i][j] = 0;
            }
            for (int left = 0; left < 100; left++) {
                int minHeight = height[i][left];
                for (int right = left; right < 100; right++) {
                    minHeight = Math.min(minHeight, height[i][right]);
                    int area = minHeight * (right - left + 1);
                    max = Math.max(max, area);
                }
            }
        }

        System.out.println(max);
    }
}