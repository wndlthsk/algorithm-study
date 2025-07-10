import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] dist = new int[N];
        Arrays.fill(dist, -1);
        dist[0] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= A[cur]; i++) {
                int next = cur + i;
                if (next < N && dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }

        System.out.println(dist[N - 1]);
    }
}
