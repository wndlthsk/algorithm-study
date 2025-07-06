// 영어 단어장의 단어 순서
// 1. 자주 나오는 단어일수록
// 2. 단어의 길이가 길수록
// 3. 알파벳 사전 순으로
// 길이가 m이상인 단어만 외운다
// n: 단어의 길이, m: 외울 단어의 길이 기준
// 1<=n<=100000, 1<=m<=10, 단어의 길이는 10이하

// 우선 순위 큐에 넣는다.?
// --> 삽입: O(logN), 꺼내기: O(logN) => n개 단어 꺼내면 O(NlogN)
// + String.compareTo() -> 시간 초과
// -> List + Collections.sort() 가 낫다

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Word implements Comparable<Word> {
    String eng;
    int len;
    int count;

    public Word(String eng, int len, int count) {
        this.eng = eng;
        this.len = len;
        this.count = count;
    }

    @Override
    public String toString() {
        return eng + " " + len + " " + count;
    }

    @Override
    public int compareTo(Word w) {
        if (this.count != w.count) {
            return w.count - this.count;
        }
        if (this.len != w.len) {
            return w.len - this.len;
        }
        return this.eng.compareTo(w.eng);
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> count = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (word.length() >= m) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }
//        System.out.println(count);
        List<Word> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : count.entrySet()) {
            list.add(new Word(entry.getKey(), entry.getKey().length(), entry.getValue()));
        }
        Collections.sort(list); // Word의 compareTo 기준으로 정렬됨

        // stringbuilder가 sout 반복보다 빠르다.
        // 출력 I/O 횟수가 줄기 때문이다.
        StringBuilder sb = new StringBuilder();
        for(Word w: list) {
            sb.append(w.eng).append('\n');
        }
        System.out.print(sb);
    }
}