// 라이언: 저번 우승자, 이번 결승정/ 결승전 상대: 어피치
// 결승전 규칙
// 1. 어피치 n발 쏜 후 라이언 n발
// 2. 점수 계산
// k점 a발, b발 중 더 많은화살을 k점에 맞춘 선수가 k점을 가져감/ a==b일경우 어피치가 k점획득
// 3. 최종 점수 높은 사람 승/ 같으면 어피치가 우승

// 현재는 라이언이 쏠 차례,
// 라이언이 가장 큰 점수차로 이기려면 n발 화살을 어떤 과녁 점수에 맞춰야하는지 구하기/ 10~0점 순서대로 정수배열 리턴
// n: 화살 개수/ info: 어피치 점수 개수 10~0점
// 라이언 우승 불가면 [-1] 리턴

// 큰 점수부터 라이언이 획득하도록
// 라이언이 가장 큰 점수 차이로 우승할 수 있는 방법이 여러 가지일 경우, 가장 낮은 점수를 더 많이 맞힌 경우를 return

import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[] info) {
        backtrack(n, info, 0, n, 0, 0);
        // System.out.println(result);

        if (maxDiff <= 0) return new int[]{-1};

        return result;
    }

    int maxDiff = 0;
    int[] counts = new int[11];
    int[] result = new int[11];

    public void backtrack(int n, int[] info, int idx, int arrowR, int ryan, int apeach) {
        if (idx == 11) {
            if (arrowR > 0) {
                counts[10] += arrowR;
            }

            // 최대 점수차 처리
            int diff = ryan - apeach;
            if (diff > 0 && maxDiff < diff) {
                maxDiff = diff;
                result = Arrays.copyOf(counts, 11);
            } else if (diff > 0 && maxDiff == diff) {
                for (int i = 10; i >= 0; i--) {
                    if (counts[i] > result[i]) {
                        result = Arrays.copyOf(counts, 11);
                        break;
                    } else if (counts[i] < result[i]) {
                        break;
                    }
                }
            }

            if (arrowR > 0) counts[10] -= arrowR;

            return;
        }


        // 현재 과녁 포함
        if (arrowR >= info[idx] + 1) {
            counts[idx] = info[idx] + 1;
            backtrack(n, info, idx+1, arrowR - (info[idx] + 1), ryan + (10 - idx), apeach);
            counts[idx] = 0;
        }

        // 현재 과녁 불포함
        // 어피치가 쏜적 없는 과녁이면 점수가 갱신되면 안됨
        int apeachNext = apeach;
        if (info[idx] > 0) apeachNext += (10 - idx);
        backtrack(n, info, idx+1, arrowR, ryan, apeachNext);
    }
}