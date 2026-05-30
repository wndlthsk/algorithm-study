// 후보키 최대 개수 구하기
// 유일성, 최소성을 만족하는 거

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    int n;
    int m;
    String[][] relation;
    List<List<Integer>> candidateKeys = new ArrayList<>();


    public int solution(String[][] relation) {
        int answer = 0;
        n = relation.length;
        m = relation[0].length;
        this.relation = relation;

        for (int i=1; i<=m; i++) {
            combination(0, i, new ArrayList<>());
        }


        return candidateKeys.size();
    }


    private void combination(int idx, int count, List<Integer> now) { // 1~m개로 조합만들면서 확인
        if (now.size() == count) {
            if (!isUnique(now)) return;

            candidateKeys.add(new ArrayList<>(now));
            return;
        }

        for (int i=idx; i<m; i++) {
            now.add(i);

            if(isMinimum(now)) combination(i+1, count, now);

            now.remove(now.size()-1);
        }
    }


    private boolean isMinimum(List<Integer> combi) {
        for(List<Integer> key: candidateKeys) {
            if (combi.containsAll(key)) return false;
        }

        return true;
    }


    private boolean isUnique(List<Integer> combi) {
        Set<String> values = new HashSet<>();

        for (String[] r: relation) {
            StringBuilder sb = new StringBuilder();
            for (int x: combi) {
                sb.append(r[x]).append("|");
            }

            values.add(sb.toString());
        }

        return values.size() == n;
    }
}