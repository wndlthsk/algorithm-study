// 두 문자열에서 가장 긴 공통 부분수열의 길이 구하기
// 공통 부분수열이 없으면 0 리턴
// 부분수열: 원래 문자열에서 일부 문자를 삭제하고 나머지 문자의 상대적 순서를 변경하지 않고 생성된 새 문자열
// dp[i][j] : text1의 i번째, text2의 j번째의 가장 긴 공통 수열 길이
// dp[i][j] = (text1[i-1] == text2[j-1]이면) dp[i-1][j-1] + 1
//            (다르면) max(dp[i-1][j], dp[i][j-1])

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for (int i=1; i<text1.length()+1; i++) {
            for (int j=1; j<text2.length()+1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        // System.out.println(Arrays.deepToString(dp));

        return dp[text1.length()][text2.length()-1];
    }
}