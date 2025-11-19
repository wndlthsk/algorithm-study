import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// nxn명 사람 정사각형 배치, 모든 의자에 번호
// 특별상 정하는 규칙
// 받을 수 있는 사람 한명이면 그사람
// 아니면 대회장을 정사각형 4개로 나우어 각구역에서 규칙을 재귀적으로 적용, 총 4명
// 4명 중 번호가 두번째로 작은 사람
// 앉아야하는 번호 리턴

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        System.out.println(Arrays.deepToString(arr));

        System.out.println(find(n, 0, 0));
    }

    public static int find(int size, int x, int y) {
        if (size == 1) {
            return arr[x][y];
        }

        List<Integer> candidates = new ArrayList<>();
        candidates.add(find(size/2, x, y));
        candidates.add(find(size/2, x, y + size/2));
        candidates.add(find(size/2, x + size/2, y));
        candidates.add(find(size/2, x + size/2, y + size/2));

        return findSecondMin(candidates);
    }

    public static int findSecondMin(List<Integer> list) {
        Collections.sort(list);

        return list.get(1);
    }
}