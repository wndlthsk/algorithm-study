import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n개 재료, 신맛 s, 쓴맛 b, 신맛 곱, 쓴맛 합
// 신맛 쓴맛의 차이를 작게, 재료는 적어도 한개

class Taste {
    int sourness;
    int bitterness;

    public Taste(int sourness, int bitterness) {
        this.sourness = sourness;
        this.bitterness = bitterness;
    }
}

public class Main {

//    static List<Taste> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
//        arr = new ArrayList<>();
        int[] s = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
//            int s = Integer.parseInt(st.nextToken());
//            int b = Integer.parseInt(st.nextToken());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
//            arr.add(new Taste(s, b));
        }

//        for (int i=1; i<=n; i++) {
//            combination(n, i, new ArrayList<>(), 0);
//        }

        dfs(n, s, b, 0, 1, 0, 0);

        System.out.println(min);

    }
    static int min = Integer.MAX_VALUE;


    static void dfs(int n, int[] s, int[] b, int idx, int sour, int bitter, int picked) {
        if (idx == n) {
            if (picked > 0) {
                min = Math.min(min, Math.abs(sour - bitter));
            }
            return;
        }

        // 현재 재료 선택
        dfs(n, s, b, idx+1, sour * s[idx], bitter + b[idx], picked+1);

        // 선택 안함
        dfs(n, s, b, idx+1, sour, bitter, picked);
    }

//
//    public static void combination(int n, int r, List<Integer> now, int start) {
//        if (now.size() == r) {
//            int S = 1;
//            int B = 0;
//            for (Integer i : now) {
//                S *= arr.get(i).sourness;
//                B += arr.get(i).bitterness;
//            }
//            min = Math.min(min, Math.abs(S - B));
//            return;
//        }
//
//        for (int i=start; i<n; i++) {
//            now.add(i);
//            combination(n, r, now, i+1);
//            now.remove(now.size()-1);
//        }
//    }
}