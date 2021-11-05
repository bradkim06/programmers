import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        if (cacheSize == 0) {
            return 5 * cities.length;
        }

        LinkedList<String> cacheList = new LinkedList<>();

        for (String str : cities) {
            str = str.toLowerCase();

            if (str.isBlank()) {
                continue;
            }

            if (cacheList.contains(str)) {
                cacheList.remove(str);
                cacheList.addFirst(str);
                answer++;
            } else {
                answer += 5;
                if (cacheList.size() == cacheSize) {
                    cacheList.pollLast();
                }
                cacheList.addFirst(str);
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[] cities = { "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul" };
        // String[] cities = { "Jeju", "Pangyo", "NewYork", "newyork" };

        System.out.println(test.solution(3, cities));
    }
}
