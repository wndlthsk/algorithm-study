package week31.우현서;// 왼 엄지: * / 오 엄지: #
// 상하좌우 4방향, 거리 1
// 1,4,7 입력은 왼 엄지 사용
// 3,6,9는 오 엄지 사용
// 2,5,8,0은 두 엄지중 가까운 거 사용, 같으면 오른손잡이->오, 왼->왼
// numbers: 순서대로 누를 번호 / hand: 왼손잡이or오른손잡이
// 각번호를 누른 엄지가 왼or오인지 리턴 LR


import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(int[] numbers, String hand) {
        Map<Integer, int[]> numMap = new HashMap<>();
        numMap.put(1, new int[]{0, 0});
        numMap.put(2, new int[]{0, 1});
        numMap.put(3, new int[]{0, 2});
        numMap.put(4, new int[]{1, 0});
        numMap.put(5, new int[]{1, 1});
        numMap.put(6, new int[]{1, 2});
        numMap.put(7, new int[]{2, 0});
        numMap.put(8, new int[]{2, 1});
        numMap.put(9, new int[]{2, 2});
        numMap.put(11, new int[]{3, 0}); // *
        numMap.put(0, new int[]{3, 1});
        numMap.put(12, new int[]{3, 2}); // #

        int left = 11;
        int right = 12;

        StringBuilder sb = new StringBuilder();
        for (int num: numbers) {
            if (num == 1 || num == 4 || num == 7) {
                sb.append("L");
                left = num;
            } else if (num == 3 || num == 6 || num == 9) {
                sb.append("R");
                right = num;
            } else {
                int[] xyL = numMap.get(left);
                int[] xyR = numMap.get(right);
                int[] target = numMap.get(num);

                // bfs로 안하고 걍 절댓값 거리 구하면 됨
                // int lenL = bfs(xyL[0], xyL[1], num);
                // int lenR = bfs(xyR[0], xyR[1], num);
                int lenL = Math.abs(xyL[0] - target[0]) + Math.abs(xyL[1] - target[1]);
                int lenR = Math.abs(xyR[0] - target[0]) + Math.abs(xyR[1] - target[1]);

                if (lenL == lenR) {
                    if (hand.equals("left")) {
                        sb.append("L");
                        left = num;
                    } else {
                        sb.append("R");
                        right = num;
                    }
                } else if (lenL < lenR) {
                    sb.append("L");
                    left = num;
                } else {
                    sb.append("R");
                    right = num;
                }
            }
        }
        // System.out.println(sb.toString());

        return sb.toString();
    }

    // int[][] keypad = {
    //     {1,2,3},
    //     {4,5,6},
    //     {7,8,9},
    //     {11,0,12}
    // };
//     int[] dx = new int[]{-1, 1, 0, 0};
//     int[] dy = new int[]{0, 0, -1, 1};

//     public int bfs(int x, int y, int target) {
//         Queue<int[]> queue = new ArrayDeque<>();
//         boolean[][] visited = new boolean[4][3];
//         queue.add(new int[]{x, y, 0});
//         visited[x][y] = true;

//         while (!queue.isEmpty()) {
//             int[] now = queue.poll();
//             int nowX = now[0];
//             int nowY = now[1];
//             int count = now[2];

//             if (keypad[nowX][nowY] == target) {
//                 return count;
//             }

//             for (int d=0; d<4; d++) {
//                 int nextX = nowX + dx[d];
//                 int nextY = nowY + dy[d];

//                 if (nextX >= 0 && nextX < 4 && nextY >= 0 && nextY < 3 && !visited[nextX][nextY]) {
//                     visited[nextX][nextY] = true;
//                     queue.add(new int[]{nextX, nextY, count+1});
//                 }
//             }
//         }

//         return -1;
//     }
}