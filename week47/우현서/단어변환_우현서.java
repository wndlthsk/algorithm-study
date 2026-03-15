import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    String[] words;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        this.words = words;

        dfs(target, begin, 0);

        return min == 50 ? 0: min;
    }

    int min = 50;
    Set<String> visited = new HashSet<>();

    public void dfs(String target, String now, int count) {
        if (now.equals(target)) {
            min = Math.min(min, count);
            return;
        }
        if (count > min) return;

        List<String> candidates = getCandidates(now);
        for (String candidate: candidates) {
            if (visited.contains(candidate)) continue;

            visited.add(candidate);
            dfs(target, candidate, count+1);
            visited.remove(candidate);
        }
    }

    public List<String> getCandidates(String str) {
        List<String> candidates = new ArrayList<>();
        char[] strChars = str.toCharArray();
        for (String word: words) {
            char[] wordChars = word.toCharArray();
            int cnt = 0;

            for (int i=0; i<wordChars.length; i++) {
                if (wordChars[i] != strChars[i]) cnt++;
                if (cnt >= 2) break;
            }

            if (cnt == 1) candidates.add(word);
        }

        return candidates;
    }
}