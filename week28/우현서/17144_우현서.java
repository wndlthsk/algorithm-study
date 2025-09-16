import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[][] A = new int[r][c];
        List<Integer> cleaner = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                if (A[i][j] == -1) {
                    cleaner.add(i);
                }
            }
        }
//        System.out.println(Arrays.deepToString(A));
//        System.out.println(cleaner);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int T=0; T<t; T++) {
            // 확산
            int[][] spread = new int[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (A[i][j] > 0) {
                        int count = 0;
                        for (int d = 0; d < 4; d++) {
                            int ni = i + dx[d];
                            int nj = j + dy[d];
                            if (ni >= 0 && ni < r && nj >= 0 && nj < c) {
                                if (A[ni][nj] != -1) {
                                    count++;
                                    spread[ni][nj] += A[i][j]/5;
                                }
                            }
                        }
                        spread[i][j] -= A[i][j]/5 * count;
                    }
                }
            }

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    A[i][j] += spread[i][j];
                }
            }

//            for (int i = 0; i < r; i++) {
//                for (int j = 0; j < c; j++) {
//                    System.out.print(A[i][j] + " ");
//                }
//                System.out.println();
//            }


            // 공기 청정기
            int top = cleaner.get(0);
//            System.out.println(top);
            for (int i=top-1; i>0; i--) {
                A[i][0] = A[i-1][0];
            }
            for (int i=0; i<c-1; i++) {
                A[0][i] = A[0][i+1];
            }
            for (int i=0; i<top; i++) {
                A[i][c-1] = A[i+1][c-1];
            }
            for (int i=c-1; i>1; i--) {
                A[top][i] = A[top][i-1];
            }
            A[top][1] = 0;

            int bottom = cleaner.get(1);
            for (int i=bottom+1; i<r-1; i++) {
                A[i][0] = A[i+1][0];
            }
            for (int i=0; i<c-1; i++) {
                A[r-1][i] = A[r-1][i+1];
            }
            for (int i=r-1; i>bottom; i--) {
                A[i][c-1] = A[i-1][c-1];
            }
            for (int i=c-1; i>1; i--) {
                A[bottom][i] = A[bottom][i-1];
            }
            A[bottom][1] = 0;


//            for (int i = 0; i < r; i++) {
//                for (int j = 0; j < c; j++) {
//                    System.out.print(A[i][j] + " ");
//                }
//                System.out.println();
//            }

        }

        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (A[i][j] > 0) {
                    result += A[i][j];
                }
            }
        }

        System.out.println(result);
    }
}