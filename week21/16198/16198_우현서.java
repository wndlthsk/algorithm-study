// n개의 에너지 구슬이 일렬로 놓여있고, 에너지 구슬을 이용해 어너지를 모은다.
// i번째 에너지 구슬의 무게는 wi이고 에너지를 모으는 방법은 다음과 같다. 반복 사용 가능
// 1. 에너지 구슬 하나를 고른다. 고른 구슬 번호 : x, 첫번째/마지막 구슬은 고를 수 없다
// 2. x번째 에너지 구슬을 제거한다.
// 3. Wx-1 * Wx+1 에너지를 모은다.
// 4. n을 1감소, 에너지 구슬 1~N번까지 번호 매긴다. 1based
// n과 에너지 구슬의 무게가 주어졌을 때 모을 수 있는 에너지 양의 최댓값 구하기

// 구슬 선택해서 넣었다 빼면서 최댓값 갱신 - 백트래킹

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> w = new ArrayList<>();
        w.add(0);
        for(int i = 1; i <= n; i++) {
            w.add(Integer.parseInt(st.nextToken()));
        }
//        System.out.println(Arrays.toString(w));

        backtrack(n, 0, 0, w);
//        backtrack2(0, w);
        System.out.println(result);
    }

    public static void backtrack(int last, int count, int sum, List<Integer> weight) {
        if (count == n-2) {
            result = Math.max(result, sum);
        }

        for (int i=2; i<last; i++) {
            int tempWeight = weight.get(i);
            int tempSum = weight.get(i-1) * weight.get(i+1);
            sum += tempSum;
            weight.remove(i);
            backtrack(last-1, count+1, sum, weight);
            weight.add(i, tempWeight);
            sum -= tempSum;
        }
    }

    public static void backtrack2(int sum, List<Integer> weight) {
        if (weight.size() == 3) {
            result = Math.max(result, sum);
            return;
        }

        for (int i=2; i<weight.size()-1; i++) {
            int energy = weight.get(i-1) * weight.get(i+1);
            List<Integer> next = new ArrayList<>(weight);
            next.remove(i);
            backtrack2(sum+energy, next);
        }
    }

}