import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
// 각 고객에게 초밥의 종류 하나의 쿠폰 발행, 위의 행사에 참여할 경우 쿠폰 종류의 초밥 하나를 무료로 추가 제공
// 가능한 다양한 종류의 초밥을 먹게

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] visited = new int[d+1];

        int count = 0;
        for (int i=0; i<k; i++) {
            if (visited[arr[i]] == 0) count++;
            visited[arr[i]]++;
        }
        int max = visited[c] == 0 ? count+1 : count;

        for (int i = 1; i < n; i++) {
            visited[arr[i-1]]--;
            if (visited[arr[i-1]] == 0) count--;

            int newIdx = (i + k-1) % n;
            if (visited[arr[newIdx]] == 0) count++;
            visited[arr[newIdx]]++;

            max = Math.max(max, visited[c] == 0 ? count+1 : count);
        }

        System.out.println(max);
    }

}