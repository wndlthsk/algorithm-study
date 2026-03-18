import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1부터 번호있는 스위치, 꺼져있거나 켜져있음
// 남 - 스위치 번호가 받은 수의 배수면 스위치 상태 변경
// 여 - 같은 번호 승위치 중심으로 좌우 대칭,가장 많은 스위치 포함하는 구간 찾아서 모두 변경
// 입력 순서대로 스위치 상태 바꿀 때 마지막 상태 출력

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());
        for (int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int number = Integer.parseInt(st.nextToken());

            if (gender == 1) { // 남
                int x = 1;
                while (number * x <= n) {
                    arr[number * x] = (arr[number * x] == 0) ? 1 : 0;
                    x++;
                }
            } else { // 여
                int p1 = number - 1;
                int p2 = number + 1;
                arr[number] = (arr[number] == 0) ? 1 : 0;

                while (true) {
                    if (p1 < 1 || p2 > n) break;
                    if (arr[p1] == arr[p2]) {
                        arr[p1] = (arr[p1] == 0) ? 1 : 0;
                        arr[p2] = (arr[p2] == 0) ? 1 : 0;
                        p1--;
                        p2++;
                    } else {
                        break;
                    }
                }
            }

        }

        for (int i=1; i<=n; i++) {
            System.out.print(arr[i] + " ");
            if (i%20 == 0) System.out.print("\n");
        }

    }

}