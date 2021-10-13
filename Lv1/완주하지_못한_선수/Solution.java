import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        String answer = "";

        for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                answer = name;
            }
        }

        return answer;
    }

    public static void main(String... Args) {
        Solution test = new Solution();

        String[] participant = { "leo", "kiki", "eden" };
        String[] completion = { "eden", "kiki" };

        System.out.println(test.solution(participant, completion));
    }
}
