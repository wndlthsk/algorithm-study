import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n*n 행렬 종이, -1/0/1
// 적절한 크기로 자른다
// 종이가 모두 같은 수면 그대로 사용
// 위가 아닌 경우 종이를 같은 크기의 9개로 자르고 각 잘린 종이에 대해 위 과정을 반복
// -1, 0, 1로만 채워진 종이 개수 구하기

public class Main {

    static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        count = new int[3];
        dfs(0, 0, n);
        for (int i = 0; i < 3; i++) {
            System.out.println(count[i]);
        }

    }

    public static void dfs(int x, int y, int size) {
        if (check(x, y, size)) return;

        int nextSize = size/3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dfs(x + i * nextSize, y + j * nextSize, nextSize);
            }
        }
    }

    static int[] count;

    public static boolean check(int x, int y, int size) {
        int base = paper[x][y];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (paper[x+i][y+j] != base) return false;
            }
        }
        count[base+1]++;
        return true;
    }
}