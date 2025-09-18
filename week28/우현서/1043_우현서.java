import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 진실 / 과장
// 어떤 사람이 진실 들었으면 무조건 진실 말해야 함
// 과장된 이야기를 할 수 있는 파티 개수의 최댓값 구하기

// 인접 리스트 만들고 bfs로 전파 처리

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        // k: 이야기 진실 아는 사람 수, 1based
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visitedPerson = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 0; i < k; i++) {
            int p = Integer.parseInt(st.nextToken());
            queue.add(p);
            visitedPerson[p] = true;
        }

        List<List<Integer>> parties = new ArrayList<>();
        for (int i=0; i<=m; i++) {
            parties.add(new ArrayList<>());
        }
        List<List<Integer>> people = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            people.add(new ArrayList<>());
        }
        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            for (int j = 1; j <= k; j++) {
                int p = Integer.parseInt(st.nextToken());
                parties.get(i).add(p);
                people.get(p).add(i);
            }
        }
//        System.out.println(parties);
//        System.out.println(people);

        boolean[] visitedParty = new boolean[m+1];

        while(!queue.isEmpty()) {
            int person = queue.poll();

            for (int party : people.get(person)) {
                if (!visitedParty[party]) {
                    visitedParty[party] = true;

                    for (int nextPerson : parties.get(party)) {
                        if (!visitedPerson[nextPerson]) {
                            queue.add(nextPerson);
                            visitedPerson[nextPerson] = true;
                        }
                    }
                }
            }
        }
//        System.out.println(Arrays.toString(visitedParty));
//        System.out.println(Arrays.toString(visitedPeople));

        int result = 0;
        for (int i=1; i<=m; i++) {
            if (!visitedParty[i]) {
                result++;
            }
        }

        System.out.println(result);
    }

}