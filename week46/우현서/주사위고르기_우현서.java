// n개 주사위,
// 주사위 굴려서 합계가 큰쪽이 승리, 점수 같으면 무승부
// a가 승률 높아지도록 주사위 가져가고 싶음, 오름차순으로 리턴

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int[] solution(int[][] dice) {
        int n = dice.length;
        combination(n, n/2, new ArrayList<>(), 0);
        // System.out.println(candidates);

        int bestWins = 0;
        List<Integer> bestPicks = null;

        for (List<Integer> pickA: candidates) {
            boolean[] isA = new boolean[n];
            for (int a: pickA) isA[a] = true;

            List<Integer> pickB = new ArrayList<>();
            for (int i=0; i<n; i++) {
                if (!isA[i]) pickB.add(i);
            }

            // 가능한 모든 합을 미리 구함
            List<Integer> sumA = new ArrayList<>();
            makeSum(dice, pickA, 0, 0, sumA);
            List<Integer> sumB = new ArrayList<>();
            makeSum(dice, pickB, 0, 0, sumB);

            // 이분탐색으로 a가 b보다 큰 경우의 수 구하기
            Collections.sort(sumB);
            int cnt = 0;

            for (int x: sumA) {
                cnt += getWinCount(sumB, x);
            }

            if (cnt > bestWins) {
                bestWins = cnt;
                bestPicks = pickA;
            }
        }

        // System.out.println(bestPicks);

        Collections.sort(bestPicks);
        int[] answer = new int[bestPicks.size()];
        for (int i=0; i<bestPicks.size(); i++) {
            answer[i] = bestPicks.get(i) + 1;
        }

        return answer;
    }

    List<List<Integer>> candidates = new ArrayList<>();

    public void combination(int n, int r, List<Integer> now, int idx) {
        if (now.size() == r) {
            candidates.add(new ArrayList<>(now));
            return;
        }

        for (int i=idx; i<n; i++) {
            now.add(i);
            combination(n, r, now, i+1);
            now.remove(now.size()-1);
        }
    }

    public void makeSum(int[][] dice, List<Integer> picked, int depth, int sum, List<Integer> result) {
        if (depth == picked.size()) {
            result.add(sum);
            return;
        }

        int diceIdx=picked.get(depth);
        for (int i=0; i<6; i++) {
            makeSum(dice, picked, depth+1, sum+dice[diceIdx][i], result);
        }
    }

    public int getWinCount(List<Integer> list, int x) {
        int l=0;
        int r=list.size()-1;

        while (l <= r) {
            int mid = (l+r)/2;
            if (list.get(mid) >= x) r = mid-1;
            else l = mid+1;
        }

        return l;
    }
}