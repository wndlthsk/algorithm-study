// 다음달에 누가 선물을 많이 받을지 예측
// 주고 받음 o -> 더 많은 선물을 준 사람이 담달에 하나 받음
// 주고 받음 x/== -> 선물 지수가 더큰 사람이 더 작은 사람에게 하나 받음
// 선물지수 = 자신이 준 선물의 수 - 받은 선물
// 선물지수도 같으면 담달에 선물 주고 받지 않음
// 가장 많이 받을 친구가 받을 선물의 수 구하기

// friends : 이름
// gifts : "A B" A->B

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Person {
    String name;
    int give;
    int take;
    int score;

    public Person (String name) {
        this.name = name;
        this.give = 0;
        this.take = 0;
        this.score = 0;
    }

    @Override
    public String toString() {
        return "[name: " + name + " give: " + give + " take: " + take + " score: " + score + "]";
    }
}

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        List<Person> people = new ArrayList<>();
        Map<String, Integer> nameIdx = new HashMap<>();

        int idx = 0;
        for(String name: friends) {
            people.add(new Person(name));
            nameIdx.put(name, idx++);
        }
        // System.out.println(people);
        // System.out.println(nameIdx);

        int n = friends.length;
        int[][] history = new int[n][n]; // i -> j 횟수

        for (String gift: gifts) {
            String[] splited = gift.split(" ");
            String a = splited[0];
            String b = splited[1];

            int i = nameIdx.get(a);
            int j = nameIdx.get(b);
            people.get(i).give++;
            people.get(j).take++;
            history[i][j]++;
        }

        // 선물 지수 계산
        for (Person p : people) {
            p.score = p.give - p.take;
        }

        // System.out.println(people);

        int[] nextMonth = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int scoreA = people.get(i).score;
                int scoreB = people.get(j).score;

                // 주고 받은 적 있음
                if (history[i][j] > history[j][i]) {
                    nextMonth[i]++;
                } else if (history[i][j] < history[j][i]) {
                    nextMonth[j]++;
                } else { // 주고 받은 적 없음
                    if (scoreA > scoreB) {
                        nextMonth[i]++;
                    } else if (scoreA < scoreB) {
                        nextMonth[j]++;
                    }
                }
            }
        }

        // System.out.println(Arrays.toString(nextMonth));

        for (int x : nextMonth) {
            answer = Math.max(answer, x);
        }

        return answer;
    }
}