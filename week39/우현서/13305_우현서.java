import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n개 도시
// 왼쪽도시에서 젤 오른쪽으로 이동
// 첫 출발시 기름 넣어야함. 기름통은 무제한
// 1km에 1l 기름 사용
// 최소 비용 계산


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] roads = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] gas = new int[n];
        for (int i = 0; i < n; i++) {
            gas[i] = Integer.parseInt(st.nextToken());
        }

        long money = (long) gas[0] * roads[0];
        int beforeMinPrice = gas[0];
        for (int i = 1; i < n-1; i++) {
            if (gas[i] > beforeMinPrice) {
                money += (long) beforeMinPrice * roads[i];
            } else {
                money += (long) gas[i] * roads[i];
                beforeMinPrice = gas[i];
            }
        }

        System.out.println(money);

    }
}