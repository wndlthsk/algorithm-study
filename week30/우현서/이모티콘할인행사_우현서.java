// 가입자 늘리기(우선), 판매액 늘리기
// n명에게 m개 할인 판매 10, 20, 30, 40 중 하나
// 각 사용자는 일정 비율 이상 할인 이모티콘을 모두 구매,
// 구매비용의 합이 일정 가격 이상이면 구매취소 후 플러스 서비스 가입
// users: n명의 구매 기준을 담은 정수 배열[비율, 가격] / emoticons: m개의 정가 정수 배열
// 플러스 가입 수와 매출액을 정수 배열로 리턴


class Solution {
    int n, m;
    public int[] solution(int[][] users, int[] emoticons) {
        n = users.length;
        m = emoticons.length;
        discounts = new int[m];

        dfs(users, emoticons, 0);

        // System.out.println(maxJoined + " " + maxPrice);
        int[] answer = new int[]{maxJoined, maxPrice};

        return answer;
    }

    int[] rates = new int[]{10, 20, 30, 40};
    int[] discounts;
    int maxJoined = 0;
    int maxPrice = 0;

    public void dfs(int[][] users, int[] emoticons, int idx) {
        if (idx == m) {
            int totalJoined = 0;
            int totalPrice = 0;
            for (int[] user: users) { // user[0]:퍼센트, user[1]:가격
                int price = 0;
                boolean joined = false;

                for (int i=0; i<m; i++) {
                    int d = discounts[i];
                    if (d >= user[0]) {
                        price += emoticons[i] * (100 - d) * 0.01;
                        if (price >= user[1] && joined == false) {
                            joined = true;
                        }
                    }
                }

                if (joined) {
                    totalJoined += 1;
                } else {
                    totalPrice += price;
                }
            }

            if (maxJoined < totalJoined) {
                maxJoined = totalJoined;
                maxPrice = totalPrice;
            } else if (maxJoined == totalJoined && maxPrice < totalPrice) {
                maxPrice = totalPrice;
            }

            return;
        }

        for (int r: rates) {
            discounts[idx] = r;
            dfs(users, emoticons, idx+1);
        }
    }
}