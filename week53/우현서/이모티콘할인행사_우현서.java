// n명 m개 할인 판매
// 이모티콘마다 할인율 다름 10/20/30/40
// 일정 비율 이상이면 구매, 비용 합이 일정 가격 이상이면 플러스 가입
// 가입자 수, 판매액 리턴

// 10~40까지 중복 순열 구해서 계산해보기

import java.util.ArrayList;
import java.util.List;

class Solution {
    int n;
    int[][] users;
    int[] emoticons;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;

        n = emoticons.length; // 이모티콘 개수

        permutation(new ArrayList<>());


        return new int[]{resultPeople, resultTotal};
    }

    int resultPeople = 0;
    int resultTotal = 0;
    int[] rates = {10, 20, 30, 40};

    private void permutation(List<Integer> now) {
        if (now.size() == n) {
            // 계산
            int[] result = calculate(now);

            // 우선순위 적용
            if (result[0] > resultPeople) {
                resultPeople = result[0];
                resultTotal = result[1];
            } else if (result[0] == resultPeople && result[1] > resultTotal) {
                resultTotal = result[1];
            }

            return;
        }

        for (int i=0; i<4; i++) {
            now.add(rates[i]);
            permutation(now);
            now.remove(now.size()-1);
        }
    }



    private int[] calculate(List<Integer> discount) {
        int people = 0;
        int totalMoney = 0;

        for (int[] user: users) {
            int stdDiscount = user[0];
            int stdTotal = user[1];

            int sum = 0;

            for (int i=0; i<n; i++) {
                if (discount.get(i) < stdDiscount) continue;

                int cost = emoticons[i] * (100-discount.get(i))/100;
                sum += cost;
            }

            if (sum >= stdTotal) people += 1;
            else totalMoney += sum;
        }

        return new int[]{people, totalMoney};
    }
}