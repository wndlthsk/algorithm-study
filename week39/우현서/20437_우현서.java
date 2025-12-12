import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// 문자열 w, 양의 정수 k
// 어떤 문자를 k개 포함하는 가장 짧은 연속 문자열의 길이 구하기
// 어떤 문자를 k개 포함, 문자열의 첫,마지막 글자가 해당 문자로 같은 가장 긴 연속 문자열 길이 구하기

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String w = br.readLine();
            int k = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (char c = 'a'; c <= 'z'; c++) {
                List<Integer> idxList = new ArrayList<>();

                for (int idx=0; idx<w.length(); idx++) {
                    char ch = w.charAt(idx);
                    if (ch == c) {
                        idxList.add(idx);
                    }
                }

                if (idxList.size() < k) continue;

                for (int idx = 0; idx <= idxList.size()-k; idx++) {
                    int length = idxList.get(idx + k - 1) - idxList.get(idx) + 1;
                    min = Math.min(min, length);
                    max = Math.max(max, length);
                }
            }

            if (min == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }
        }
    }
}