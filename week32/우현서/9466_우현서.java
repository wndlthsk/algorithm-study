package week32.우현서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 팀원수 제한x
// 모든 학생들은 함께 하고 싶은 학생을 선택해야함. 자기자신 선택도 가능
// 4-> 7, 7-> 6, 6->4 여야 한팀 가능
// 어느 팀에도 속하지 않는 학생 수 구하기
// 사이클 찾고 포함되는 애들 카운트


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] students = new int[n+1];
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }
//            System.out.println(Arrays.toString(students));

            boolean[] visited = new boolean[n+1];
            boolean[] done = new boolean[n+1];
            count = 0;
            for (int i = 1; i <= n; i++) {
                if (!done[i]) {
                    dfs(students, visited, done, i);
                }
            }
            System.out.println(n - count);
        }
    }

// dfs(1) -> (3) visited t -> (3) done -> (3) return

    static int count;
    public static void dfs(int[] students, boolean[] visited, boolean[] done, int now) {
        if (done[now]) return;

        if (visited[now]) {
            count++;
            done[now] = true;
        }

        visited[now] = true;
        dfs(students, visited, done, students[now]);
        done[now] = true;
    }

}