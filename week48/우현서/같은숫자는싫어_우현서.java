import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[] solution(int []arr) {

        Queue<Integer> queue = new LinkedList<>();
        int before = arr[0];
        queue.offer(arr[0]);

        for (int i=1; i<arr.length; i++) {
            int now = arr[i];
            if (before == now) continue;
            else {
                queue.offer(now);
                before = now;
            }
        }


        int[] answer = new int[queue.size()];
        int i=0;
        for (int x: queue) {
            answer[i] = x;
            i++;
        }


        return answer;
    }
}