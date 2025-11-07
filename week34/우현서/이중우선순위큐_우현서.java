import java.util.TreeMap;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        // 트리맵
        // 최솟값 firstKey(), 최댓값 lastKey()
        // put(key, value) / get(key) / remove(key)
        TreeMap<Integer, Integer> map = new TreeMap<>(); // 숫자,

        for (String op: operations) {
            String[] splited = op.split(" ");

            int num = Integer.parseInt(splited[1]);
            // System.out.println(Arrays.toString(splited));

            if (splited[0].equals("I")) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            } else {
                if (map.isEmpty()) continue;

                if (num == 1) {
                    int max = map.lastKey();
                    int count = map.get(max);
                    if (count == 1) map.remove(max);
                    else map.put(max, count - 1);
                } else {
                    int min = map.firstKey();
                    int count = map.get(min);
                    if (count == 1) map.remove(min);
                    else map.put(min, count - 1);
                }
            }
        }

        if (map.isEmpty()) return new int[]{0, 0};
        return new int[]{map.lastKey(), map.firstKey()};
    }
}