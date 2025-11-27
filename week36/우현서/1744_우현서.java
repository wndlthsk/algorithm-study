import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 길이 n 수열, 수열 합 구하기
// 수열의 두 수 묶음, 묶은수는 서로 곱한 후 더함
// 자기자신 묶는 거 불가
// 모든 수는 한번만 묶거나 묶지 x
// 합 최대가 되게

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        int oneCount = 0;
        boolean hasZero = false;

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x > 1) pos.add(x);
            else if (x == 1) oneCount++;
            else if (x == 0) hasZero = true;
            else neg.add(x);
        }

        Collections.sort(pos, Collections.reverseOrder());
        Collections.sort(neg);

        int sum = 0;

        for (int i=0; i<pos.size()-1; i+=2) {
            sum += pos.get(i) * pos.get(i+1);
        }
        if (pos.size() % 2 == 1) {
            sum += pos.get(pos.size() - 1);
        }

        for (int i=0; i<neg.size()-1; i+=2) {
            sum += neg.get(i) * neg.get(i+1);
        }
        if (neg.size() % 2 == 1 && !hasZero) {
            sum += neg.get(neg.size() - 1);
        }

        sum += oneCount;

        System.out.println(sum);
    }
//
//    static boolean[] visited;
//    static int result = Integer.MIN_VALUE;
//
//    // 묶거나 안묶거나
//    public static void dfs(int start, int sum) {
//        if (start >= n) {
//            result = Math.max(result, sum);
//            return;
//        }
//
//        if (visited[start]) {
//            dfs(start + 1, sum); // 이미 사용됨, 다음 인덱스로
//            return;
//        }
//
//        // 두 수 묶음
//        visited[start] = true;
//        for (int j = start + 1; j < n; j++) {
//            if (visited[j]) continue;
//            visited[j] = true;
//            dfs(start+1, sum + arr[start] * arr[j]);
//            visited[j] = false;
//        }
//        visited[start] = false;
//
//        // 안 묶음
//        visited[start] = true;
//        dfs(start+1, sum + arr[start]);
//        visited[start] = false;
//    }

}