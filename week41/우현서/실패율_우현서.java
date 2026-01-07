// N: 전체 스테이지 개수
// stages: 사용자가 현재 도전 중인 스테이지의 번호
// 실패율 높은 스테이지부터 내림차순 배열 리턴
// 실패율 같으면 작은번호 스테이지 먼저
// 스테이지에 도달한 유저가 없으면 실패율 0

// N+1이면 마지막까지 클리어한 사용자

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class State {
    Double passed;
    Double trying;

    public State(Double passed, Double trying) {
        this.passed = passed;
        this.trying = trying;
    }

    @Override
    public String toString() {
        return "[passed: " + passed + " trying: " + trying + "]";
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, State> stageMap = new HashMap<>();

        for (int i=1; i<=N; i++) {
            stageMap.put(i, new State(0.0, 0.0));
        }

        for (int s: stages) {
            for (int x=1; x<s; x++) {
                State state = stageMap.get(x);
                state.passed++;
            }

            if (s == N+1) continue;
            State state = stageMap.get(s);
            state.trying++;
        }
        // System.out.println(stageMap);

        Map<Integer, Double> failureMap = new HashMap<>();
        for (Map.Entry<Integer, State> entry : stageMap.entrySet()) {
            Integer stage = entry.getKey();
            State state = entry.getValue();
            Double pt = state.passed + state.trying;
            if (pt == 0.0) {
                failureMap.put(stage, 0.0);
            } else {
                Double failure = (Double) state.trying / pt;
                failureMap.put(stage, failure);
            }
        }
        // System.out.println(failureMap);

        List<Map.Entry<Integer, Double>> list = new ArrayList<>(failureMap.entrySet());
        list.sort((e1, e2) -> {
            int cmp = Double.compare(e2.getValue(), e1.getValue());
            if (cmp != 0) return cmp;
            return Integer.compare(e1.getKey(), e2.getKey());
        });

        int[] answer = list.stream()
            .mapToInt(Map.Entry::getKey)
            .toArray();

        return answer;
    }
}