import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 흰점 0, 검은 점 1
// 같은 숫자의 점이 한곳에 몰려있으면 압축
// 숫자 섞여있으면 4등분해서 왼위 오위 왼아 오아

public class Main {

    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        result = new StringBuilder();
        dfs(0, 0, n);
        System.out.println(result);


    }
    static StringBuilder result;

    public static void dfs(int x, int y, int size) {
        if (check(x, y, size)) {
            result.append(arr[x][y]);
            return;
        }

        int nextSize = size/2;
        result.append("(");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                dfs(x + i*nextSize, y + j*nextSize, nextSize);
            }
        }
        result.append(")");

    }

    public static boolean check(int x, int y, int size) {
        int base = arr[x][y];
        for (int i=0; i<size; i++) {
            for (int j=0; j<size; j++) {
                if (arr[x+i][y+j] != base) return false;
            }
        }

        return true;
    }
}