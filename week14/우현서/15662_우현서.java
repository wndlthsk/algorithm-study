import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int[][] wheels = new int[t][8];
        for (int i = 0; i < t; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheels[i][j] = s.charAt(j) - '0'; // n극: 0, s극: 1
            }
        }
//        System.out.println(Arrays.deepToString(wheels));
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); // 회전시킨 톱니바퀴 번호
            int direction = Integer.parseInt(st.nextToken()); // 방향 (1: 시계, -1: 반시계)
//            System.out.println(x + " " + y);
            num--; // 0부터 시작해서
            int[] rotation = new int[t];
            rotation[num] = direction;

            // 왼쪽
            for (int j=num-1; j>=0; j--) {
                if (wheels[j][2] != wheels[j+1][6]){
                    rotation[j] = -rotation[j+1];
                } else {
                    break;
                }
            }

            // 오른쪽
            for (int j=num+1; j<t; j++) {
                if (wheels[j][6] != wheels[j-1][2]) {
                    rotation[j] = -rotation[j-1];
                } else {
                    break;
                }
            }

            // 회전
            for (int j=0; j<t; j++) { // 톱니바퀴 번호
                if (rotation[j] == 1) {
                    int[] temp = new int[8];
                    temp[0] = wheels[j][7];
                    for (int p=0; p<7; p++) {
                        temp[p+1] = wheels[j][p];
                    }
                    wheels[j] = temp;
                } else if (rotation[j] == -1) {
                    int[] temp = new int[8];
                    temp[7] = wheels[j][0];
                    for (int p=1; p<8; p++) {
                        temp[p-1] = wheels[j][p];
                    }
                    wheels[j] = temp;
                }
            }
//            for (int[] wheel: wheels) {
//                System.out.println(Arrays.toString(wheel));
//            }
        }

        int count = 0;
        for (int[] wheel: wheels) {
            if (wheel[0] == 1) {
                count++;
            }
        }
        System.out.println(count);
    }
}