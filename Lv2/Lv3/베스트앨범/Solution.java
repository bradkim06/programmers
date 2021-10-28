import java.util.*;

class Solution {

    public static class Music {
        int play;
        int idx;

        public Music(int play, int idx) {
            this.play = play;
            this.idx = idx;
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String key = genres[i];
            int value = plays[i];

            map.put(key, map.getOrDefault(key, 0) + value);
        }

        ArrayList<String> genres_ordered = new ArrayList<>(map.keySet());
        Collections.sort(genres_ordered, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        ArrayList<Music> result = new ArrayList<>();
        for (String gern : genres_ordered) {
            ArrayList<Music> list = new ArrayList<>();
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(gern)) {
                    list.add(new Music(plays[i], i));
                }
            }
            Collections.sort(list, (o1, o2) -> o2.play - o1.play); // 내림차순 소팅

            result.add(list.get(0));
            if (list.size() > 1) {
                result.add(list.get(1));
            }
        }

        // print result
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i).idx;
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[] genres = { "classic", "pop", "classic", "classic", "pop" };
        int[] plays = { 500, 600, 150, 800, 2500 };
        System.out.println(Arrays.toString(test.solution(genres, plays)));
    }
}
