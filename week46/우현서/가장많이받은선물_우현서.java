// 다음달에 누가 선물을 많이 받을지 예측
// 주고 받음 o -> 더 많은 선물을 준 사람이 담달에 하나 받음
// 주고 받음 x/== -> 선물 지수가 더큰 사람이 더 작은 사람에게 하나 받음
// 선물지수 = 자신이 준 선물의 수 - 받은 선물
// 선물지수도 같으면 담달에 선물 주고 받지 않음
// 가장 많이 받을 친구가 받을 선물의 수 구하기

// friends : 이름
// gifts : "A B" A->B

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        int n = friends.length;

        Map<String, Integer> idx = new HashMap<>();
        for (int i=0; i<n; i++) {
            idx.put(friends[i], i);
        }

        int[][] history = new int[n][n]; // i->j 횟수
        int[] out = new int[n]; // 선물 준 횟수
        int[] in = new int[n]; // 선물 받은 횟수

        for (String g: gifts) {
            String[] splited = g.split(" ");
            int from = idx.get(splited[0]);
            int to = idx.get(splited[1]);
            history[from][to]++;
            out[from]++;
            in[to]++;
        }

        int[] result = new int[n];

        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int aToB = history[i][j];
                int bToA = history[j][i];

                if (aToB > bToA) {
                    result[i]++;
                } else if (bToA > aToB) {
                    result[j]++;
                } else {
                    int scoreA = out[i] - in[i];
                    int scoreB = out[j] - in[j];
                    if (scoreA > scoreB) {
                        result[i]++;
                    } else if (scoreB > scoreA) {
                        result[j]++;
                    }
                }
            }
        }

        int max = 0;
        for (int r: result) {
            max = Math.max(max, r);
        }

        return max;
    }
}