// 큐가 비어있으면 [0,0] 비어있지 않으면 남은 거 중에 [최댓값, 최솟값]을 return

// 스트링 비교: a.compareTo(b) 오름차순

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};

        PriorityQueue<Integer> pqMax = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> pqMin = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        Map<Integer, Integer> countMap = new HashMap<>();





        for (String operation: operations) {
            String[] splited = operation.split(" ");
            String op = splited[0];
            Integer num = Integer.parseInt(splited[1]);

            if (op.equals("I")) {
                pqMax.offer(num);
                pqMin.offer(num);
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);

            } else {
                if (num == 1) {

                    while (!pqMax.isEmpty()) {
                        int max = pqMax.poll();

                        if (countMap.get(max) > 0) {
                            countMap.put(max, countMap.get(max) - 1);
                            break;
                        }
                    }

                } else {

                    while (!pqMin.isEmpty()) {
                        int min = pqMin.poll();

                        if (countMap.get(min) > 0) {
                            countMap.put(min, countMap.get(min) - 1);
                            break;
                        }
                    }

                }
            }
        }

        // 남은 최대 최소 구하기
        int maxResult = 0;
        int minResult = 0;

        while (!pqMax.isEmpty()) {
            int max = pqMax.poll();
            if (countMap.get(max) > 0) {
                maxResult = max;
                break;
            }
        }

        while (!pqMin.isEmpty()) {
            int min = pqMin.poll();
            if (countMap.get(min) > 0) {
                minResult = min;
                break;
            }
        }

        if (maxResult == 0 && minResult == 0) return new int[]{0, 0};

        return new int[]{maxResult, minResult};
    }
}