// 도넛: n개 정점, n개 간선
// 막대: n개 정점, n-1개 간선
// 8자: 2n+1개 정점, 2n+2개 간선
// edges  [a,b] : a->b
// 생성한 정점의 번호, 도넛 모양 그래프의 수, 막대 모양 그래프의 수, 8자 모양 그래프의 수 리턴

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {};

        int n = 0; // 노드 수
        for (int[] e: edges) {
            n = Math.max(n, e[0]);
            n = Math.max(n, e[1]);
        }
        int[] in = new int[n+1];
        int[] out = new int[n+1];
        boolean[] exists = new boolean[n + 1];

        for (int[] e: edges) {
            int a = e[0];
            int b = e[1];
            in[b]++;
            out[a]++;
            exists[a] = true;
            exists[b] = true;
        }

        // 새로 추가된 노드는 in 0, out만 2이상
        // 막대는 out이 0인 끝점이 존재
        // 8자는 중간점이 항상 out 2
        // 도넛은 남은거
        int newNode = 0;
        int donut = 0;
        int stick = 0;
        int eight = 0;

        for (int i=0; i<=n; i++) {
            if (!exists[i]) continue;
            int countIn = in[i];
            int countOut = out[i];

            if (countIn == 0 && countOut >= 2) {
                newNode = i;
                break;
            }
        }

        for (int i=0; i<=n; i++) {
            if (!exists[i]) continue;
            int countIn = in[i];
            int countOut = out[i];

            if (i != newNode && countOut == 0) {
                // System.out.println("stick: " + i);
                stick++;
            } else if (i != newNode && countOut == 2) {
                // System.out.println("eight: " + i);
                eight++;
            }

        }
        donut = out[newNode] - stick - eight;

        return new int[]{newNode, donut, stick, eight};
    }
}