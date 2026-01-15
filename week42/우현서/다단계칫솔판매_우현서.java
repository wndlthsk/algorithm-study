// 칫솔의 판매 이익에서 10%를 추천인에게 배분하고 나머지는 자신이 가짐
// 10% 계산할때 원 단위에서 절사, 계산한 금액이 1원 미만인 경우 이득을 분배 x
// 칫솔 개당 100원
// enroll : 판매원 이름 배열
// referral : 각 판매원을 조직에 참여시킨 다른 판매원 이름 배열
// seller : 판매량의 판매원 이름 배열
// amount : 판매 수열 배열
// 각 판매원이 득한 이익금을 나열한 배열 리턴

// 판매원 이름을 정수로 변환 -> HashMap
// 부모 정보를 저장 -> 무조건 각 판매원의 부모는 1명이니까 int[]
// while문 돌다가 다음 인덱스가 center를 가리키면 종료

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, Integer> node = new HashMap<>();
        node.put("center", 0);
        for (int i=1; i<=enroll.length; i++) {
            node.put(enroll[i-1], i);
        }
        // System.out.println(node);

        int[] parent = new int[enroll.length+1];
        parent[0] = -1; // root
        for (int i=0; i<enroll.length; i++) {
            parent[i+1] = referral[i].equals("-") ? 0: node.get(referral[i]);
        }
        // System.out.println(Arrays.toString(parent));


        int[] result = new int[enroll.length]; // root빼고

        for (int i=0; i<seller.length; i++) {
            int idx = node.get(seller[i]);
            int money = amount[i] * 100;

            while (idx != 0) {
                result[idx-1] += money - money / 10;
                money = money / 10;
                if (money == 0) break;
                idx = parent[idx];
            }
        }
        // System.out.println(Arrays.toString(result));

        return result;
    }
}