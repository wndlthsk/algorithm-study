// 이모티콘 s개 보낸다
// 이미 화면에 1개 입력한 상태
// 3가지 연산만 사용해서 s개 만드려고 한다.
// 1. 화면에 있는 거 모두 복사해서 클립보드에 저장
// 2. 클립보드에 있는 모든 거 화면에 붙여넣기
// 3. 화면에 있는 이모티콘 중 하나 삭제
// 모든 연산은 1초,
// 클립보드에 임티 복사하면 이전 내용은 덮어씀/ 클립보드 비어있는 상태에서는 붙여넣기 불가, 일부 복사 불가, 일부 삭제 불가
// 걸리는 시간의 최솟값

// 여기서 그래프의 정점(노드) = (화면에 있는 이모티콘 개수, 클립보드에 있는 이모티콘 개수)라는 상태
// 간선(이동) = “복사 / 붙여넣기 / 삭제”라는 연산
// 가중치 = 모든 연산이 1초 → 즉, 모든 간선의 비용이 1
// 가중치가 전부 1인 최단 거리 문제는 BFS로 푸는 게 가장 효율적

// bfs를 자주쓰던 4방향 확장은 현재 위치에서 이동 가능한 모든 칸을 큐에 넣는 것을 의미했다.
// 이 문제에서는 방향이 아니라 행동이 3가지가 있는 것이다.
// 복사 (항상 가능) : (screen, clip) -> (screen, screen)
// 붙여넣기 (clip > 0 && screen + clip <= s 일때 가능): (screen, clip) -> (screen + clip, clip)
// 삭제 (screen > 0 일 떄 가능): (screen, clip) -> (screen - 1, clip)

// visited[screen][clip] -> 같은 상태 (화면, 클립보드)를 중복 방문하는 걸 막기 위해서


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[s+1][s+1]; // 화면, 클립보드
        queue.add(new int[]{1, 0, 0}); // 화면에 임티 개수, 클립보드에 임티 개수, 걸린 시간
        visited[1][0] = true;

        int result = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int screen = now[0];
            int clip = now[1];
            int time = now[2];

            if (screen == s) {
                result = time;
                break;
            }

            // 복사
            if (!visited[screen][screen]) {
                visited[screen][screen] = true;
                queue.add(new int[]{screen, screen, time + 1});
            }
            // 붙여넣기
            if (clip > 0 && screen + clip <= s) {
                if (!visited[screen + clip][clip]) {
                    visited[screen + clip][clip] = true;
                    queue.add(new int[]{screen + clip, clip, time + 1});
                }
            }
            // 삭제
            if (screen > 0) {
                if (!visited[screen - 1][clip]) {
                    visited[screen - 1][clip] = true;
                    queue.add(new int[]{screen - 1, clip, time + 1});
                }
            }
        }

        System.out.println(result);
    }
}