// 최소 필요 피로도, 소모 피로도
// 현재 남은 피로도 >= 최소 필요 피로도, 탐험후 현재 -소모 피로도
// 하루에 한번씩 탐험할 수 있는 던전 여러개
// 최대한 던전을 많이 탐험, 최대 던전 수 리턴
// k: 현재 피로도
// dungeons: ["최소 필요 피로도", "소모 피로도"]

// 순열 구해서 모두 계산해보기 -> n!
// -> 백트래킹으로 풀자

// 백트래킹
class Solution {
    int n;
    boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        backtrack(dungeons, 0, k);

        return answer;
    }

    int answer = 0;

    public void backtrack(int[][] dungeons, int count, int k) {
        answer = Math.max(answer, count);

        for (int i=0; i<n; i++) {
            if (visited[i]) continue;
            if (k < dungeons[i][0]) continue;
            visited[i] = true;
            backtrack(dungeons, count + 1, k - dungeons[i][1]);
            visited[i] = false;
        }
    }
}


// 순열로 완탐
//import java.util.*;
//class Solution {
//    public int solution(int k, int[][] dungeons) {
//         output = new ArrayList<>();
//         visited = new boolean[n];
//         candidates = new HashSet<>();
//         permutation(0, n, n);
//         // System.out.println(candidates);
//
//         int answer = 0;
//         for (List<Integer> can: candidates) {
//             int count = 0;
//             int copyK = k;
//             for (int c: can) {
//                 if (copyK < dungeons[c][0]) continue;
//                 copyK -= dungeons[c][1];
//                 count++;
//             }
//             answer = Math.max(answer, count);
//         }
//
//         return answer;
//    }
//
//     List<Integer> output;
//     boolean[] visited;
//     Set<List<Integer>> candidates;
//
//     public void permutation(int depth, int n, int r) {
//         if(depth == r) {
//             candidates.add(new ArrayList<>(output));
//             return;
//         }
//
//         for(int i = 0; i < n; i++) {
//             if(!visited[i]) {
//                 visited[i] = true;
//                 output.add(i);
//                 permutation(depth + 1, n, r);
//                 output.remove(output.size()-1);
//                 visited[i] = false;
//             }
//         }
//     }
//}