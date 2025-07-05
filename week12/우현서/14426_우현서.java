// 문자열 m개 중 집합 s에 포함되어 있는 문자열 중 적어도 하나의 접두사인 것의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[] s1 = new String[n];
        for (int i = 0; i < n; i++) {
            s1[i] = br.readLine();
        }
        Arrays.sort(s1); // O(nlogn)
//        System.out.println(Arrays.toString(s));

        String[] s2 = new String[m];
        for (int i = 0; i < m; i++) {
            s2[i] = br.readLine();
        }
        Arrays.sort(s2); // O(mlogm)

        int count = 0;
        int i = 0, j = 0;
        while(i < n && j < m) { // O(n+m)
            if (s1[i].startsWith(s2[j])) { // O(L)
                count++;
                j++;
            } else if (s1[i].compareTo(s2[j]) > 0) { // O(L)
                j++;
            } else if (s1[i].compareTo(s2[j]) < 0) { // O(L)
                i++;
            }

        }
        System.out.println(count);
    }

}