// dpMax[i][j] : i부터 j번째 숫자까지 괄호 어떻게 치든 젤 최댓값
// +인 경우: Math.max(dpMax[i][j], dpMax[i][k]+dpMax[k+1][j]);
// -인 경우: Math.max(dpMax[i][j], dpMax[i][k]-dpMin[k+1][j]);

// dpMin[i][j] : i부터 j번째 숫자까지 괄호 어떻게 치든 젤 최솟값
// +인 경우:  Math.min(dpMin[i][j], dpMin[i][k]+dpMin[k+1][j]);
// -인 경우: Math.min(dpMin[i][j], dpMin[i][k]-dpMax[k+1][j]);


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class Solution {
    public int solution(String arr[]) {
        int answer = -1;
        int numCount = arr.length/2+1;
        List<Integer> nums = new ArrayList<>();
        List<String> ops = new ArrayList<>();

        for (int i=0; i<arr.length; i++) {
            if (i%2 == 0) nums.add(Integer.parseInt(arr[i]));
            else ops.add(arr[i]);
        }

        int[][] dpMax = new int[numCount][numCount];
        int[][] dpMin = new int[numCount][numCount];

        for (int[] d: dpMax){
            Arrays.fill(d, Integer.MIN_VALUE);
        }
        for (int[] d: dpMin){
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        for (int i=0; i<numCount; i++) {
            dpMax[i][i] = nums.get(i);
            dpMin[i][i] = nums.get(i);
        }

        for (int i=numCount-1; i>=0; i--) { // 뒤부터 해야 짧은 길이 먼저 채워짐
            for (int j=i+1; j<numCount; j++) {
                for (int k=i; k<j; k++) {
                    String op = ops.get(k);

                    if (op.equals("+")) {
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k]+dpMax[k+1][j]);
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k]+dpMin[k+1][j]);
                    } else {
                        dpMax[i][j] = Math.max(dpMax[i][j], dpMax[i][k]-dpMin[k+1][j]);
                        dpMin[i][j] = Math.min(dpMin[i][j], dpMin[i][k]-dpMax[k+1][j]);
                    }
                }
            }
        }


        return dpMax[0][numCount-1];
    }
}