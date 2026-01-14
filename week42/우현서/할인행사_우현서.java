// 일정 금액 지불시 10일동안 회원 자격 부여
// 회원 대상 매일 한가지 제품 할인 행사
// 할인 제품은 하루에 하나씩만 구배 가능
// 정현이는 원하는 제품과 수량이 할인하는 날짜와 10일 연속으로 일치할 경우에 맞춰서 회원가입
// want: 원하는 제품 배열
// number: 원하는 제품 수량 배열
// discount: 할인하는 제품 배열
// 정현이가 회원등록 날짜의 총 일수를 리턴, 없으면 0 리턴

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> goods = new HashMap<>();
        for (int i=0; i<want.length; i++) {
            goods.put(want[i], number[i]);
        }
        // System.out.println(goods);

        int count = 0;
        for (int i=0; i<=discount.length-10; i++) {
            Map<String, Integer> copy = new HashMap<>(goods);

            for (int j=i; j<i+10; j++) {
                if (copy.containsKey(discount[j])) { // want에 있는 것만 감소
                    copy.put(discount[j], copy.get(discount[j]) - 1);
                }
            }

            boolean flag = true;
            for (int v: copy.values()) {
                if (v != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) count++;
        }

        return count;
    }
}