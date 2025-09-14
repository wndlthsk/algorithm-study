// 수빈 n, 동생 k
// 수빈 걸으면 1초 후 x -> x-1 / x+1
// 수빈 순간이동 0초 후  x-> 2x
// 수빈이 동생 찾는 가장 빠른 시간이 몇 초 후인지 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Deque<Integer> queue = new ArrayDeque<>();
        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        queue.add(n);
        dist[n] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == k) {
                System.out.println(dist[k]);
                break;
            }

            if (x-1 >= 0 && x-1 <= 100000 && dist[x-1] > dist[x] + 1){
                queue.add(x-1);
                dist[x-1] = dist[x] + 1;
            }
            if (x+1 >= 0 && x+1 <= 100000 && dist[x+1] > dist[x] + 1){
                queue.add(x+1);
                dist[x+1] = dist[x] + 1;
            }
            if (2*x >= 0 && 2*x <= 100000 && dist[2*x] > dist[x]){
                queue.addFirst(2*x);
                dist[2*x] = dist[x];
            }
        }

    }
}