// 1~n번을 키순대로 줄 세움 1-based
// 일부 학생의 키를 비교함 a<b
// 오름차순으로 출력, 여러가지면 아무거나

// 위상 정렬
// x보다 작은 사람 없으면 답에 추가한다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }
        int[] countSmaller = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList.get(a).add(b);
            countSmaller[b]++;
        }

//        System.out.println(Arrays.toString(countSmaller));
//        System.out.println(adjList);

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (countSmaller[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int now = queue.poll();
            result.add(now);

            for (Integer num : adjList.get(now)) {
                countSmaller[num]--;
                if (countSmaller[num] == 0) {
                    queue.add(num);
                }
            }
        }

        for (int x: result) {
            System.out.print(x + " ");
        }
    }
}