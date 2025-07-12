// 1~49에서 수 6개를 고른다
// k개의 수를 골라 집합 s를 만든 후 그 수만 가지고 번호를 선택한다.
// k>6, 사전순 정렬

// 49개 중 k개 뽑고, k개 중 6개를 뽑는다.
// 조합 구현

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            int[] s = new int[k];
            for (int i = 0; i < k; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> result = new ArrayList<>();
            combination(s, new ArrayList<>(), result, 0, k);

            for(List<Integer> list : result){
                System.out.println(list.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(" "))
                );
            }
            System.out.println();
        }
    }

    public static void combination(int[] s, List<Integer> cur, List<List<Integer>> result, int start, int k) {
        if (cur.size() == 6) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i=start; i<k; i++) {
            cur.add(s[i]);
            combination(s, cur, result, i+1, k);
            cur.remove(cur.size()-1);
        }
    }
}