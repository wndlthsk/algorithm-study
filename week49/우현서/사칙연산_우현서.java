// 계산 순서에 따른 최댓값 구하기

// dp[i][j] = i ~ j 구간 값, 최대/최소 같이 관리
// 왜 dp인가? 계속 부분 결과값이 반복되어 사용되기때문

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int solution(String arr[]) {
        int n = arr.length/2 + 1;

        List<Integer> nums = new ArrayList<>();
        List<String> ops = new ArrayList<>();

        int idx = 0;
        for (String c: arr) {
            if (idx % 2 == 0) {
                nums.add(Integer.parseInt(c));
            } else {
                ops.add(c);
            }
            idx++;
        }
        // System.out.println(nums);
        // System.out.println(ops);


        int[][] dpMax = new int[n][n];
        int[][] dpMin = new int[n][n];


        for (int i = 0; i < n; i++) {
            dpMax[i][i] = nums.get(i);
            dpMin[i][i] = nums.get(i);
        }

        // 구간 길이 기준 (i~j 거리)
        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;

                dpMax[i][j] = Integer.MIN_VALUE;
                dpMin[i][j] = Integer.MAX_VALUE;

                // i~k, k+1~j로 분할
                for (int k = i; k < j; k++) {
                    String op = ops.get(k);

                    int max = 0, min = 0;

                    if (op.equals("+")) {
                        max = dpMax[i][k] + dpMax[k+1][j];
                        min = dpMin[i][k] + dpMin[k+1][j];
                    } else {
                        max = dpMax[i][k] - dpMin[k+1][j];
                        min = dpMin[i][k] - dpMax[k+1][j];
                    }

                    dpMax[i][j] = Math.max(dpMax[i][j], max);
                    dpMin[i][j] = Math.min(dpMin[i][j], min);
                }
            }
        }

        return dpMax[0][n-1];
    }
}