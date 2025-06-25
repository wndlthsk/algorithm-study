// 가로세로 100 정사각형 도화지
// 가로세로 10인 색종이가 붙은 영역의 넓이

// 100*100에 표시

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[][] paper = new int[100][100];

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int a = x; a < x+10; a++) {
                for (int b = y; b < y+10; b++) {
                    paper[a][b] = 1;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j] == 1) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}