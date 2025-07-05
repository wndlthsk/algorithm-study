// nxm 종이, 종이 각 칸에 놓인 정육면체 개수가 주어질 때 겉넓이 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m  = Integer.parseInt(st.nextToken());
        int[][] paper = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(paper));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int total = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int h = paper[i][j];
                // 4방향 돌면서 주위 블럭보다 크면 차이만큼 더한다, 적으면 0 더한다
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];
                    int nh = 0;
                    if (nx>=0 && nx<n && ny>=0 && ny<m) {
                        nh = paper[nx][ny];
                    }
                    total += Math.max(0, h-nh);
                }
            }
        }
        total += 2 * (n*m);
        System.out.println(total);
    }

}