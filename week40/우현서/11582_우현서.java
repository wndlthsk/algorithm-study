import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 치킨 집의 맛의 수치를 감소하지 않는 순으로 정렬
// 치킨집 n개,
// n개의 치킨 수치를 무작위로 놓은 뒤 n/2명의 회원이 차례대로 2개의 치킨집을 선택해 정렬
// n/4명이 차례대로 바로 전단계의 사람이 정렬한 두개의 그룹을 차례대로 선택해 정렬
// n/8, n/16, .. 마지막 사람이 두개의 정렬된 그룹을 합병하며 완료
// 현재 단계에서 k명의 회원이 정렬 진행후 결과 출력


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        int size = 2;
        while (n / size >= k) {
            for (int i=0; i<n/size; i++) {
                int[] temp = new int[size];
                for (int j=0; j<size; j++) {
                    temp[j] = arr[j + i*size];
                }
                Arrays.sort(temp);
                for (int j=0; j<size; j++) {
                    arr[j + i*size] = temp[j];
                }
            }
            size *= 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(arr[i] + " ");
        }
        System.out.println(sb);
    }
}