// 장르별 가장 많이 재생된 노래 2개씩 모아 앨범 출시
// 속한 노래가 많이 재생된 장르 먼저
// 장르 내에서 많이 재생된 노래 먼저
// 같으면 고유 번호 낮은 노래 먼저
// genres: 노래 장르 나타내는 문자열 배열
// plays: 노래별 재생 횟수 배열
// 앨범에 들어갈 노래 고유 번호 순서대로 리턴

// 해시맵 삽입 [put, getOrDefalut, computIfAbsent]
// genreCounts.put(genres[i], genreCounts.getOrDefault(genres[i], 0) + plays[i]);
// genreSongs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));

// 해시맵 키값만 정렬 [keySet(), valueSet(), entrySet()]
// List<String> genreOrder = new ArrayList<>(genreCounts.keySet());
// genreOrder.sort((a, b) -> Integer.compare(genreCounts.get(b), genreCounts.get(a)));

// 객체 리스트 정렬
// List<Song> songs = genreSongs.get(genre);
// songs.sort((a, b) -> {
//     if (a.count != b.count) return Integer.compare(b.count, a.count);
//     return Integer.compare(a.idx, b.idx);
// });

// 정렬 쓸때 빼기 말고 Integer.compare 이거 써야 오버플로우 안난다!!

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Song {
    int idx;
    int count;

    public Song(int idx, int count) {
        this.idx = idx;
        this.count = count;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreCounts = new HashMap<>();
        Map<String, List<Song>> genreSongs = new HashMap<>();

        for (int i=0; i<genres.length; i++) {
            genreCounts.put(genres[i], genreCounts.getOrDefault(genres[i], 0) + plays[i]);
            genreSongs.computeIfAbsent(genres[i], k -> new ArrayList<>()).add(new Song(i, plays[i]));
        }

        List<String> genreOrder = new ArrayList<>(genreCounts.keySet());
        genreOrder.sort((a, b) -> Integer.compare(genreCounts.get(b), genreCounts.get(a)));

        List<Integer> result = new ArrayList<>();
        for (String genre: genreOrder) {
            List<Song> songs = genreSongs.get(genre);
            songs.sort((a, b) -> {
                if (a.count != b.count) return Integer.compare(b.count, a.count);
                return Integer.compare(a.idx, b.idx);
            });

            for (int i=0; i<Math.min(2, songs.size()); i++) {
                result.add(songs.get(i).idx);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}