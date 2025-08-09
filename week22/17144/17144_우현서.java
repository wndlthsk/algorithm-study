// rxc의 격자판
// 공기청정기는 1번 열에 설치, 크기는 두 행 차지
// 공기청정기 설치 안된 칸에는 미세먼지가 있고 양은 A(r,c)이다
// 1초동안 일어나는 일:
// 1. 미세먼지 확산. 미세먼지 있는 모든 칸에서 동시에
// 4방향 확산
// 인접한 방향에 공청기 있거나 칸없으면 확산x
// 확산되는 양은 A(r,c)/5이고 소수점 버림
// (r,c)에 남은 양은 A(r,c) - A(r,c)*확산된 방향 수
// 2. 공청기 작동
// 위 -> 바람이 반시계 순환 / 아래 -> 시계 순환
// 바람 방향대로 모두 한칸씩 이동
// 공청기로 들어간 미세먼지는 모두 정화됨
// t초가 지난후 남아있는 미세먼지의 양 구하기

// 1 -> bfs로 확산 (x, 순차여서 안됨) -> 동시에 확산되기 위해 미리 확산 양을 계산하고 원본을 갱신해야함
// 공청기 위
// 아래 가로: 왼 -> 오 / 오 세로: 아래->위 / 위 가로 : 오->왼 / 왼쪽 세로줄 : 위->아래
// 공청기 아래
// 위 가로 : 왼 -> 오 / 오 세로: 위->아래 / 아래 가로: 오->왼 / 왼쪽 세로줄 : 아래->위


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int[][] A = new int[r][c];
        int[] cleaner = new int[2]; // 공청기 위치 저장
        int idx = 0;

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    cleaner[idx] = i;
                    idx++;
                }
                A[i][j] = num;
            }

        }

        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};

        for (int time = 0; time < t; time++) {
            // 1. 확산
            int[][] spread = new int[r][c]; // 1초 동안 각 칸의 확산 양
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if (A[i][j] > 0) {
                        int amount = A[i][j]/5;
                        int count = 0;
                        for (int d = 0; d < 4; d++) {
                            int ni = i + dx[d];
                            int nj = j + dy[d];
                            if (ni >= 0 && ni < r && nj >= 0 && nj < c) {
                                if (A[ni][nj] != -1) {
                                    spread[ni][nj] += amount; // 각 칸에 퍼진 양 저장
                                    count++; // 퍼진 칸 카운트
                                }
                            }
                        }
                        A[i][j] -= amount * count; // 퍼진만큼 빼기
                    }
                }
            }
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    A[i][j] += spread[i][j]; // 1초동안 확산 양 갱신
                }
            }

            // 2. 순환
            // 위쪽 순환
            int top = cleaner[0];
            // 1. 왼쪽 세로줄 (아래 → 위)
            for (int i = top - 1; i > 0; i--) {
                A[i][0] = A[i - 1][0];
            }
            // 2. 윗 가로줄 (왼 → 오)
            for (int j = 0; j < c - 1; j++) {
                A[0][j] = A[0][j + 1];
            }
            // 3. 오른쪽 세로줄 (위 → 아래)
            for (int i = 0; i < top; i++) {
                A[i][c - 1] = A[i + 1][c - 1];
            }
            // 4. 공청기 줄 (오 → 왼)
            for (int j = c - 1; j > 1; j--) {
                A[top][j] = A[top][j - 1];
            }
            A[top][1] = 0;

            // 아래 순환
            int down = cleaner[1];
            // 1. 위->아래
            for (int i = down+1; i < r-1; i++) {
                A[i][0] = A[i+1][0];
            }
            // 2. 왼 -> 오
            for (int j = 0; j < c-1; j++) {
                A[r-1][j] = A[r-1][j+1];
            }
            // 3. 아래 -> 위
            for (int i = r-1; i > down; i--) {
                A[i][c-1] = A[i-1][c-1];
            }
            // 4. 오 -> 왼
            for (int j = c-1; j > 1; j--) {
                A[down][j] = A[down][j-1];
            }
            A[down][1] = 0;
        }

        int result = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (A[i][j] > 0) {
                    result += A[i][j];
                }
            }
        }
//        System.out.println(Arrays.deepToString(A));

        System.out.println(result);
    }
}