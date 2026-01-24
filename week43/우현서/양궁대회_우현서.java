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

class Solution {
    int N;
    int[] apeach;

    public int[] solution(int n, int[] info) {
        N = n;
        apeach = info.clone();

        backtrack(0, 0, 0, 0);

        if (maxDiff == 0) return new int[]{-1};
        else return result;
    }

    int maxDiff = 0;
    int[] result = new int[11];
    int[] ryan = new int[11];


    public void backtrack(int score, int usedArrows, int ryanScore, int apeachScore) {
        if (score == 11) {
            if (usedArrows < N) ryan[10] += N - usedArrows;
            calcDiff(ryanScore, apeachScore);
            if (usedArrows < N) ryan[10] -= N - usedArrows;

            return;
        }

        // 이미 화살 다썼으면 가지치기 & 남은 점수들 중 어피치가 쏜 게 있으면 점수 더하기
        if (usedArrows == N) {
            for (int s=score; s<11; s++) {
                if (apeach[10-s] > 0) apeachScore += s;
            }
            calcDiff(ryanScore, apeachScore);

            return;
        }

        int needArrows = apeach[10-score] + 1;

        // 현재 점수 먹기
        if (needArrows <= N - usedArrows) {
            ryan[10-score] = needArrows;
            backtrack(score+1, usedArrows + needArrows, ryanScore + score, apeachScore);
            ryan[10-score] = 0;
        }

        // 현재 점수 포기
        int apeachNextScore = apeachScore;
        if (apeach[10-score] > 0) apeachNextScore += score;
        backtrack(score+1, usedArrows, ryanScore, apeachNextScore);
    }

    private void calcDiff(int ryanScore, int apeachScore) {
        int diff = ryanScore - apeachScore;
        if (diff <= 0) return;

        if (diff > maxDiff) {
            maxDiff = diff;
            result = ryan.clone();
        } else if (diff == maxDiff) {
            if (isBetter()) result = ryan.clone();
        }
    }

    private boolean isBetter() {
        for (int i=10; i>=0; i--) {
            if (result[i] < ryan[i]) return true;
            else if (result[i] > ryan[i]) return false;
        }

        return false;
    }
}