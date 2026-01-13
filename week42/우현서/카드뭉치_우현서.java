// 카드의 단어를 사용해 원하는 순서의 단어 배열을 만들 수 있는지
// 카드뭉치에서 순서대로 한장씩 사용
// 한번 사용한 카드는 다시 사용 불가
// cards1, cards2 : 카드 뭉치
// goal 만들수 있으면 Yes, 아니면 No 리턴

// 카드 뭉치 각각 큐로 바꾸고 각각 첫번째 단어가 goal[i]가 아니면 no

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> queue1 = new ArrayDeque<>();
        Queue<String> queue2 = new ArrayDeque<>();

        for (String c: cards1) {
            queue1.add(c);
        }
        for (String c: cards2) {
            queue2.add(c);
        }

        for (String g: goal) {
            if (!queue1.isEmpty() && queue1.peek().equals(g)) queue1.poll();
            else if (!queue2.isEmpty() && queue2.peek().equals(g)) queue2.poll();
            else return "No";
        }

        return "Yes";
    }
}

// 큐 사용 x
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0;
        int j = 0;
        for (String g: goal) {
            if (i < cards1.length && cards1[i].equals(g)) i++;
            else if (j < cards2.length && cards2[j].equals(g)) j++;
            else return "No";
        }

        return "Yes";
    }
}