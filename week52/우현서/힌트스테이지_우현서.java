// 1->n번 순서대로 스테이지 해결
// 필요한 최소 비용 구하기

// 각 단계에서
// 힌트권 최대 n-1개 사용 가능, 초기에는 없음
// 힌트 번들 살 수 있음. 비용, 종류는 다름


// 스테이지 수 최대가 16. dfs로 완탐....
// 힌트권 관리하면서

import java.util.HashMap;
import java.util.Map;

class Solution {

    int n;
    int k;
    int[][] cost;
    int[][] hint;

    public int solution(int[][] cost, int[][] hint) {
        this.cost = cost;
        this.hint = hint;

        n = cost.length;
        k = hint[0].length-1;

        Map<Integer, Integer> hintCount = new HashMap<>();
        for (int i=1; i<=n; i++) {
            hintCount.put(i, 0);
        }
        dfs(1, 0, hintCount);

        return minCost;
    }


    int minCost = Integer.MAX_VALUE;

    public void dfs(int stage, int nowCost, Map<Integer, Integer> hintCount) {

        if (stage > n) {
            minCost = Math.min(minCost, nowCost);
            return;
        }

        int count = hintCount.get(stage);
        count = (count >= n) ? n-1 : count;

        int newCost = nowCost + cost[stage-1][count];


        // 번들 안 사고 다음 스테이지
        dfs(stage+1, newCost, hintCount);



        // 마지막 스테이지는 번들 살거 없음
        if (stage == n) return;


        // 번들 사고 다음 스테이지
        Map<Integer, Integer> nextMap = new HashMap<>(hintCount);

        int[] bundle = hint[stage-1];
        int bundleCost = bundle[0];

        int noNeedToBuy = 0;
        for (int i=1; i<=k; i++) {
            if (nextMap.get(bundle[i]) == n-1) {
                noNeedToBuy++;
            }
        }

        // 모두 n-1개 넘으면 굳이 번들 안사도 됨
        if (noNeedToBuy == k) return;

        newCost += bundleCost;

        for (int i=1; i<=k; i++) {
            nextMap.put(bundle[i], nextMap.get(bundle[i])+1);
        }


        dfs(stage+1, newCost, nextMap);

    }
}