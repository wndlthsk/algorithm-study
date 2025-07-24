// 장르별 가장 많이 재생된 노래 2개씨 모아 베스트 앨범
// 노래는 고유번호로 구분, 수록 기준은 다음과 같다.
// 1. 속한 노래가 많이 재생된 장르 먼저 수록 (장르별 노래 재생횟수 -> 내림차순)
// 2. 장르 내에서 많이 재생된 노래 먼저 수록 (노래 재생횟수 -> 내림차순)
// 3. 장르 내에서 재생 횟수가 같은 노래 중에서는 고유번호가 낮은 노래 먼저 수록 (고유번호 -> 오름차순)
// genres: 노래 장르
// plays: 노래별 재생횟수
// 베스트 앨범에 들어가 노래의 고유번호를 순서대로 리턴

// 객체 만들어서 Comparable을 implements해서 compareTo를 구성한다.


import java.util.*;


class Song implements Comparable<Song>{
    int num;
    int count;

    public Song(int num, int count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public String toString() {
        return "[" + num + ", " + count + "]";
    }

    @Override
    public int compareTo(Song s) {
        if (this.count != s.count) {
            return s.count - this.count;
        }
        return this.num - s.num;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int n = genres.length;

        // 장르별 카운트
        Map<String, Integer> genreCount = new HashMap<>();
        for (int i=0; i<n; i++) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        // 장르 정렬
        List<Map.Entry<String, Integer>> sortedGenre = new ArrayList<>(genreCount.entrySet());
        sortedGenre.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        // 장르 내 정렬
        Map<String, List<Song>> songs = new HashMap<>();
        for (int i=0; i<n; i++) {
            songs.putIfAbsent(genres[i], new ArrayList<>());
        }
        for (int i=0; i<n; i++) {
            songs.get(genres[i]).add(new Song(i, plays[i]));
        }
        for (String genre: songs.keySet()) {
            Collections.sort(songs.get(genre));
        }

        // 최대 2개씩 뽑기
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedGenre) {
            String genre = entry.getKey();
            List<Song> s = songs.get(genre);
            for (int i=0; i<Math.min(2, s.size()); i++) {
                result.add(s.get(i).num);
            }
        }

        // 리스트를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}