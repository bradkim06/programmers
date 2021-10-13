import java.util.HashMap;
import java.util.Collections;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], phone_book[i].length());
        }

        Integer minLength = Collections.min(map.values());

        for (int i = 0; i < phone_book.length; i++) {
            for (int j = minLength; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String... Args) {
        Solution test = new Solution();

        String[] phone_book = { "12", "123", "1235", "567", "88" };

        System.out.println(test.solution(phone_book));
    }
}
