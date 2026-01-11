// n*n 게임화면, 위쪽 크레인, 오른쪽 바구니
// 인형은 격자 가장 아래부터 쌓임
// 크레인 좌우 움직여 멈춘 위치에서 가장 위의 인형 집음, 바구니 아래칸부터 쌓임
// 같은 인형이 바구니에 연속 쌓이면 두 인형은 없어짐
// 인형없는 곳에 크레인 작동시 아무일 x
// board: 게임화면 격자 상태
// moves: 크레인 작동 위치
// 모든 작동후 터트려져 사라진 인형 개수 리턴

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;

        List<Deque<Integer>> stacks = new ArrayList<>();
        for (int i=0; i<n; i++) {
            stacks.add(new ArrayDeque<>());
        }
        for (int i=n-1; i>=0; i--) {
            for (int j=0; j<n; j++) {
                if (board[i][j] == 0) continue;
                Deque<Integer> stack = stacks.get(j);
                stack.addLast(board[i][j]);
            }
        }
        // System.out.println(stacks);

        int count=0;
        Deque<Integer> basket = new ArrayDeque<>();
        for (int m: moves) {
            int idx = m-1;

            if (stacks.get(idx).isEmpty()) continue;
            int x = stacks.get(idx).peekLast();
            stacks.get(idx).pollLast();

            if(!basket.isEmpty() && basket.peekLast() == x) {
                basket.pollLast();
                count += 2;
                // System.out.println("basket: " + basket + " stacks[i]: " + stacks.get(idx) + "count: " + count);
            } else {
                basket.addLast(x);
            }
            // System.out.println("m: " + m + " basket: " + basket);
        }

        return count;
    }
}