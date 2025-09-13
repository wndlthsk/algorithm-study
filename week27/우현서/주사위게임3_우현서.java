import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> count = new HashMap();
        count.put(a, count.getOrDefault(a, 0) + 1);
        count.put(b, count.getOrDefault(b, 0) + 1);
        count.put(c, count.getOrDefault(c, 0) + 1);
        count.put(d, count.getOrDefault(d, 0) + 1);
        // System.out.println(count);

        int size = count.size();
        if (size == 1) {
            answer = 1111 * a;
        } else if (size == 2) {
            List<Integer> keys = new ArrayList<>(count.keySet());
            int first = count.get(keys.get(0));
            int second = count.get(keys.get(1));
            int p, q;
            if (first == 3) {
                p = keys.get(0);
                q = keys.get(1);
                answer = (int) Math.pow(10 * p + q, 2);
            } else if (second == 3) {
                p = keys.get(1);
                q = keys.get(0);
                answer = (int) Math.pow(10 * p + q, 2);
            } else if (first == second) {
                p = keys.get(0);
                q = keys.get(1);
                answer = (p + q) * Math.abs(p - q);
            }
        } else if (size == 3) {
            List<Integer> keys = new ArrayList<>(count.keySet());
            int f = count.get(keys.get(0));
            int s = count.get(keys.get(1));
            int t = count.get(keys.get(2));
            int p=0, q=0, r=0;
            if (f == 2) {
                p = keys.get(0);
                q = keys.get(1);
                r = keys.get(2);
            }
            else if (s == 2) {
                p = keys.get(1);
                q = keys.get(0);
                r = keys.get(2);
            }
            else if (t == 2) {
                p = keys.get(2);
                q = keys.get(1);
                r = keys.get(0);
            }
            answer = q * r;
        } else if (size == 4) {
            List<Integer> keys = new ArrayList<>(count.keySet());
            answer = Collections.min(keys);
        }

        return answer;
    }
}