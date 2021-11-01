import java.util.*;

class Solution {
    final String[] lower = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z" };
    final String[] lowChange = { "z", "y", "x", "w", "v", "u", "t", "s", "r", "q", "p", "o", "n", "m", "l", "k", "j",
            "i", "h", "g", "f", "e", "d", "c", "b", "a" };

    public String solution(String word) {
        String answer = "";

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < lower.length; i++) {
            map.put(lower[i], lowChange[i]);
            map.put(lower[i].toUpperCase(), lowChange[i].toUpperCase());
        }

        for (int i = 0; i < word.length(); i++) {
            String ch = word.substring(i, i + 1);

            if (map.containsKey(ch)) {
                System.out.printf("ch : %s change : %s\n", ch, map.get(ch));
                answer += map.get(ch);
            } else {
                answer += ch;
            }
        }

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        System.out.println(test.solution("I love you"));
    }
}
