import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 폭발 문자열 폭발하면 문자가 문자열에서 사라지고 남은 건 합쳐짐
// 폭발 과정
// 폭발 문자열 포함하면 모든 폭발 문자열 폭벌, 남은 문자열을 순서대로 이어붙여 새로운 문자열 만든다
// 새로운 문자열에 폭발 문자열이 있을 수도
// 폭발 문자열이 없을 때까지 계속 폭발
// 모든 폭발 끝난 후 문자열 출력, 없으면 FRULA


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();

        int sLength = s.length();
        int bombLength = bomb.length();

        char[] stack = new char[sLength];

        int pointer = 0;
        for (int i=0; i<sLength; i++) {
            stack[pointer] = s.charAt(i);
            pointer++;

            if (pointer >= bombLength) {
//                System.out.println("stack: " + Arrays.toString(stack));
                boolean isBomb = true;
                for (int j=0; j<bombLength; j++) {
                    if (stack[pointer - bombLength + j] != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    pointer -= bombLength;
                }
            }
        }

        if (pointer == 0) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<pointer; i++) {
                sb.append(stack[i]);
            }
            System.out.println(sb);
        }
    }
}