import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// <, > k개 나열된 A
// 부등호 앞뒤에 한자리 수 넣어서 모든 부등호 관계 만족시키도록
// 0~9
// 이 순서를 만족시키는 정수 중 최대, 최소

public class Main {

    static int k;
    static char[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new char[k];
        for (int i = 0; i < k; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
//        System.out.println(Arrays.toString(arr));


        visited = new boolean[10];
        for (int i = 0; i < 10; i++) {
            visited[i] = true;
            backtrack(0, String.valueOf(i));
            visited[i] = false;
        }
        System.out.println(max);
        System.out.println(min);

    }

    static boolean[] visited;
    static String max = null;
    static String min = null;

    public static void backtrack(int arrIdx, String number) {
        if (number.length() == k+1) {
            if (min == null || number.compareTo(min) < 0) min = number;
            if (max == null || number.compareTo(max) > 0) max = number;
            return;
        }

        for (int i=0; i<10; i++) {
            if (!visited[i]) {
                char c = arr[arrIdx];
                int before = number.charAt(number.length()-1) - '0';
                if ((c == '>' && before > i) || (c == '<' && before < i)) {
                    visited[i] = true;
                    backtrack(arrIdx+1, number+i);
                    visited[i] = false;
                }
            }
        }

    }



}