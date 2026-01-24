// 어피치 다쏘고 라이언이 쏨
// k점에 더 많이 맞춘 사람이 k점을 가져감, 같으면 어피치가 가져감
// 최종 점수가 더 큰 사람이 우승자, 같으면 어피치 승

// 라이언이 어피치를 가장 큰 점수 차로 이기기 위해 어떤 과녁 점수에 맞혀야하는지 구하기
// 여러가지면, 가장 낮은 점수를 더 많이 맞힌 경우 리턴
// info: 어피치가 맞힌 과녁 점수 개수를 10점~0점까지
// 라이언이 우승할 수 없으면 -1 배열

// 점수차가 최대가 되려면 높은 점수를 라이언이 먹어야함  ?? 아니어도 되는듯
// 왜 백트래킹?  --> 선택의 조합을 전부 비교해야 하는 구조. 각 점수를 먹을지 말지의 조합
// 각 점수를 라이언이 먹엇다고 가정하고 점수 차 큰것을 후보로 저장, 후보 중 낮은 점수 많은 거 구해

import java.util.ArrayList;
import java.util.List;

class Solution {
    int N;
    int[] apeach;

    public int[] solution(int n, int[] info) {
        N = n;
        apeach = info.clone();

        backtrack(0, 0, new int[11]);
        // System.out.println(maxDiff);

        // for (int[] c: candidates) {
        //     System.out.println(Arrays.toString(c));
        // }


        int size = candidates.size();
        if (size == 0) return new int[]{-1};
        else if (size == 1) return candidates.get(0);
        else { // 후보중 베스트 구하기
            int[] best = candidates.get(0);

            for (int i=1; i<size; i++) {
                int[] now = candidates.get(i);

                for (int j=10; j>=0; j--) {
                    if (best[j] < now[j]) {
                        best = now;
                        break;
                    } else if (best[j] > now[j]) {
                        break;
                    }
                }
            }

            return best;
        }
    }

    int maxDiff = 0;
    List<int[]> candidates = new ArrayList<>();


    public void backtrack(int score, int usedArrows, int[] lion) {
        if (score >= 11) {
            lion[10] += N - usedArrows;
            calcDiff(lion);
            lion[10] -= N - usedArrows;

            return;
        }

        if (usedArrows == N) {
            calcDiff(lion);
            return;
        }

        int needArrows = apeach[10-score] + 1;

        // 현재 점수 먹기
        if (needArrows <= N - usedArrows) {
            lion[10-score] = needArrows;
            backtrack(score+1, usedArrows + needArrows, lion);
            lion[10-score] = 0;
        }

        // 현재 점수 포기
        backtrack(score+1, usedArrows, lion);
    }

    private void calcDiff(int[] lion) {
        int diff = 0;
        for (int i=0; i<11; i++) {
            if (lion[i] > apeach[i]) diff += 10-i;
            else if (apeach[i] > 0) diff -= 10-i;
        }

        if (diff <= 0) return;

        if (diff > maxDiff) {
            candidates.clear();
            candidates.add(lion.clone());
            maxDiff = diff;
        } else if (diff == maxDiff) {
            candidates.add(lion.clone());
        }
    }
}