import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (String key : map.keySet()) {
            answer *= map.get(key) + 1;
        }

        answer--;

        return answer;
    }

    public static void main(String... args) {
        Solution test = new Solution();

        String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
                { "green_turban", "headgear" } };
        System.out.println(test.solution(clothes));
    }
}
