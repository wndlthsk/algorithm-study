// 각 물질에 1~n번 번호
// 가장 밀도 높은 물질 찾기, 밀도 = 무게 / 부피
// 밀도가 같으면 더 무거은 물질 번호, 둘다 같다면 번호가 작은 물질 번호

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Info {
    int idx;
    int weight;
    double density;

    public Info(int idx, int weight, double density) {
        this.idx = idx;
        this.weight = weight;
        this.density = density;
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Info> infos = new ArrayList<>();
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            infos.add(new Info(i+1, w, (double)w/v));
        }

        Collections.sort(infos, (a, b) -> {
            if (a.density != b.density) return Double.compare(b.density, a.density);
            if (a.weight != b.weight) return Integer.compare(b.weight, a.weight);
            return Integer.compare(a.idx, b.idx);
        });

        System.out.println(infos.get(0).idx);
    }
}