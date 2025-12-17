import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 두 문자열에 모두 포함된 가장 긴 공통부분 문자열 찾기

// str1[i] == str2[j] 이면, dp[i][j] = dp[i-1][j-1] + 1
// dp[i][j] : str1의 i번째 문자와 str2의 j번째 문자로 끝나는 가장 긴 공통 부분 문자열의 길이

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length()][str2.length()];
        int result = 0;
        for (int i=0; i<str1.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                dp[i][0] = 1;
                result = Math.max(result, dp[i][0]);
            }
        }
        for (int j=0; j<str2.length(); j++) {
            if (str1.charAt(0) == str2.charAt(j)) {
                dp[0][j] = 1;
                result = Math.max(result, dp[0][j]);
            }
        }

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                    result = Math.max(result, dp[i][j]);
                }
            }
        }

//        System.out.println(Arrays.deepToString(dp));
        System.out.println(result);

    }
}