// -0
//|1 | 2
// - 3
//|4 | 5
// -6
// 0: [0,1,2,4,5,6]
// 1: [2,5]
// 2: [0,2,3,4,6]
// 3: [0,2,3,5,6]
// 4: [1,2,3,5]
// 5: [0,1,3,5,6]
// 6: [0,1,3,4,5,6]
// ...
// 출력 줄 0 -> 0 | 1~s -> 1,2 | s+1 -> 3 | s+2~2s+1 -> 4,5 | 2s+2 -> 6

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        String n = st.nextToken();

        int[][] segments = {
            {0,1,2,4,5,6},    // 0
            {2,5},            // 1
            {0,2,3,4,6},      // 2
            {0,2,3,5,6},      // 3
            {1,2,3,5},        // 4
            {0,1,3,5,6},      // 5
            {0,1,3,4,5,6},    // 6
            {0,2,5},          // 7
            {0,1,2,3,4,5,6},  // 8
            {0,1,2,3,5,6}     // 9
        };


        boolean[][] mark = new boolean[10][7]; // 숫자 9개, 세그먼트 7개
        for (int i=0; i<10; i++) {
            for (int seg: segments[i]) {
                mark[i][seg] = true;
            }
        }
//        System.out.println("mark: "+Arrays.deepToString(mark));

        // 출력 줄 0 -> 0 | 1~s -> 1,2 | s+1 -> 3 | s+2~2s+1 -> 4,5 | 2s+2 -> 6
        // 줄 0
        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            System.out.print(" ");
            if (mark[num][0]) {
                System.out.print("-".repeat(s));
            } else {
                System.out.print(" ".repeat(s));
            }
            System.out.print(" ");
            System.out.print(" "); // 숫자 사이 공백
        }
        System.out.println();

        // 줄 1~s
        for (int i = 0; i < s; i++) {
            for (int j=0; j < n.length(); j++) {
                int num = n.charAt(j) - '0';
                if (mark[num][1]) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
                System.out.print(" ".repeat(s));
                if (mark[num][2]) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
                System.out.print(" "); // 숫자 사이 공백
            }
            System.out.println();
        }

        // 줄 s+1
        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            System.out.print(" ");
            if (mark[num][3]) {
                System.out.print("-".repeat(s));
            } else {
                System.out.print(" ".repeat(s));
            }
            System.out.print(" ");
            System.out.print(" "); // 숫자 사이 공백
        }
        System.out.println();

        // 줄 s+2~2s+1
        for (int i = 0; i < s; i++) {
            for (int j=0; j < n.length(); j++) {
                int num = n.charAt(j) - '0';
                if (mark[num][4]) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
                System.out.print(" ".repeat(s));
                if (mark[num][5]) {
                    System.out.print("|");
                } else {
                    System.out.print(" ");
                }
                System.out.print(" "); // 숫자 사이 공백
            }
            System.out.println();
        }

        // 줄 2s+2
        for (int i = 0; i < n.length(); i++) {
            int num = n.charAt(i) - '0';
            System.out.print(" ");
            if (mark[num][6]) {
                System.out.print("-".repeat(s));
            } else {
                System.out.print(" ".repeat(s));
            }
            System.out.print(" ");
            System.out.print(" "); // 숫자 사이 공백
        }
        System.out.println();
    }
}