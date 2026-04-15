// 카메라 한번은 만나게 설치
// 최소 몇 대 카메라 설치해야하는지 리턴
// [진입지점, 나간 지점]

// -20 -------- -15
//-18 ------- -13
// -14 ------ -5
// -5 ----3
// 나간지점 기준 오름차순 정렬, -15에 설치하고 그걸로 커버되는 거 통과

import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        int camera = Integer.MIN_VALUE;

        for (int[] r: routes) {
            if (r[0] > camera) {
                answer++;
                camera = r[1];
            }
        }


        return answer;
    }
}

// 통과는 되지만 틀린 풀이
// out이 겹치는 전체 구간의 최적 대표점이 아님

// class Solution {
//     public int solution(int[][] routes) {
//         int answer = 0;

//         Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

//         int n = routes.length;

//         for (int i=0; i<n; i++) {
//             int out = routes[i][1];
//             int jump = 0;
//             answer++;

//             for (int j=i+1; j<n; j++) {
//                 int[] car = routes[j];
//                 if (out >= car[0] && out <= car[1]) jump++;
//                 else break;
//             }

//             i += jump;
//         }

//         return answer;
//     }
// }