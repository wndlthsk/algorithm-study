import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// 크기 n인 수열
// 오등큰수 : 오른쪽, 수열 a에서 등장한 횟수가 x가 a에 등장한 횟수보다 큰 수 중 가장 왼쪽에 있는 수
// 없으면 -1

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> numCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numCount.put(a[i], numCount.getOrDefault(a[i], 0) + 1);
        }

        // 오등큰수가 안정해진 인덱스를 넣는다
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[n];
        Arrays.fill(result, -1);
        for (int i=0; i<n; i++) {
            // 지금 i번째 숫자가 스택에 쌓인 것들보다 크면 i숫자가 스택에 있는 거의 오등큰수
            while(!stack.isEmpty() && numCount.get(a[stack.peek()]) < numCount.get(a[i])) {
                result[stack.pop()] = a[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int x: result) {
            sb.append(x).append(" ");
        }
        System.out.println(sb.toString());

    }

}