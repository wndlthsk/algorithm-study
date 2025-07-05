// 입력: 팔린 책 제목
//  n: 팔린 개수 (<=1000)
//  책 제목 길이 <= 50, 알파벳 소문자
// 출력: 가장 많이 팔린 책의 제목
//  여러 개일 경우, 사전 순 출력

// 책 제목, 개수로 객체 만들어서
// 개수 -> 제목 으로 정렬
// 객체 말고 Map쓰면 탐색이 더 빠르다(O(1))

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, Integer> books = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String title = br.readLine();
            books.put(title, books.getOrDefault(title, 0) + 1);
        }
//        System.out.println(books);

        // value(개수)로 내림차순 -> key(제목) 오름차순
        List<Entry<String, Integer>> list = new ArrayList<>(books.entrySet());
        list.sort((a, b) -> {
            int tmp = b.getValue() - a.getValue();
            if (tmp == 0) { // 같으면
                return a.getKey().compareTo(b.getKey());
            }
            return tmp;
        });

        System.out.println(list.get(0).getKey());
    }
}